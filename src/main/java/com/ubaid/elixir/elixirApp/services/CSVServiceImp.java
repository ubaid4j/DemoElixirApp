package com.ubaid.elixir.elixirApp.services;

import com.ubaid.elixir.elixirApp.cvsUtil.CSVReader;
import com.ubaid.elixir.elixirApp.dto.Contract;
import com.ubaid.elixir.elixirApp.entity.ContractEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CSVServiceImp implements CSVService {

    @Override
    public List<Contract> getContracts(File file) {
        List<ContractEntity> entities = CSVReader.getContracts(file);
        assert entities != null;
        return entities.stream().map(ContractEntity::getContract).collect(Collectors.toList());
    }
}
