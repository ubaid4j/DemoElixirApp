package com.ubaid.elixir.elixirApp.services;

import com.ubaid.elixir.elixirApp.common.TableHeader;
import com.ubaid.elixir.elixirApp.dto.Contract;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *     This service is responsible for getting all Contract (row of csv files) from  a given file and
 *     A File (all distinct items of an header) from the given csv file
 * </p>
 * @author ubaid
 */
public interface CSVService {
    /**
     *
     * @param file (given csv file)
     * @return all rows of the csv file (contracts)
     */
    List<Contract> getContracts(File file);

    /**
     *
     * @param file given csv file
     * @return all distinct items of an header
     */
    Map<TableHeader, Set<String>> getFilters(File file);
}
