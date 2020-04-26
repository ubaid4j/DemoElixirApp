package com.ubaid.elixir.elixirApp.cvsUtil;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ubaid.elixir.elixirApp.entity.Contract;

import java.io.*;
import java.util.List;

public class CSVReader {

    public static List<Contract> getContracts(File file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            CsvToBean<Contract> loadedData = new CsvToBeanBuilder<Contract>(reader)
                    .withType(Contract.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return loadedData.parse();
        } catch (IOException exp) {
            exp.printStackTrace();
            return null;
        }
    }
}
