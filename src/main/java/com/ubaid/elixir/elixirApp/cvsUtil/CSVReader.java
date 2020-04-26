package com.ubaid.elixir.elixirApp.cvsUtil;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ubaid.elixir.elixirApp.entity.ContractEntity;

import java.io.*;
import java.util.List;

/**
 * <p>
 *     This class is responsible to parse csv data from a given file to ContractEntities
 *     This class using open csv library for parsing csv data
 * </p>
 * @author ubaid
 */
public class CSVReader {

    /**
     *
     * @param file csv file
     * @return list of ContractEntity entities
     */
    public static List<ContractEntity> getContracts(File file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            CsvToBean<ContractEntity> loadedData = new CsvToBeanBuilder<ContractEntity>(reader)
                    .withType(ContractEntity.class)
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
