package com.ubaid.elixir.elixirApp.services;

import com.ubaid.elixir.elixirApp.common.TableHeader;
import com.ubaid.elixir.elixirApp.dto.Contract;
import com.ubaid.elixir.elixirApp.entity.ContractEntity;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CSVService {
    List<Contract> getContracts(File file);
    Map<TableHeader, Set<String>> getFilters(File file);
}
