package com.ubaid.elixir.elixirApp.services;

import com.ubaid.elixir.elixirApp.dto.Contract;
import com.ubaid.elixir.elixirApp.entity.ContractEntity;

import java.io.File;
import java.util.List;

public interface CSVService {
    List<Contract> getContracts(File file);
}
