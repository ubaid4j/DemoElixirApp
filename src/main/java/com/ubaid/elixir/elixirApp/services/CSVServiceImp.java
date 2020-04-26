package com.ubaid.elixir.elixirApp.services;

import com.ubaid.elixir.elixirApp.common.TableHeader;
import com.ubaid.elixir.elixirApp.cvsUtil.CSVReader;
import com.ubaid.elixir.elixirApp.dto.Contract;
import com.ubaid.elixir.elixirApp.entity.ContractEntity;
import com.ubaid.elixir.elixirApp.factory.FilterFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CSVServiceImp implements CSVService {

    @Override
    public List<Contract> getContracts(File file) {
        List<ContractEntity> entities = CSVReader.getContracts(file);
        assert entities != null;
        return entities.stream().map(ContractEntity::getContract).collect(Collectors.toList());
    }

    @Override
    public Map<TableHeader, Set<String>> getFilters(File file) {
        List<ContractEntity> entities = CSVReader.getContracts(file);
        assert entities != null;
        return FilterFactory.createFilters(entities.stream().map(ContractEntity::getContract).collect(Collectors.toList()));
    }
}
