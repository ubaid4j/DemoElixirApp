package com.ubaid.elixir.elixirApp.services;

import com.ubaid.elixir.elixirApp.cvsUtil.CSVReader;
import com.ubaid.elixir.elixirApp.entity.Contract;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CSVServiceImp implements CSVService {
    @Override
    public List<Contract> getContracts(File file) {
        return CSVReader.getContracts(file);
    }
}
