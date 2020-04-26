package com.ubaid.elixir.elixirApp.factory;

import com.ubaid.elixir.elixirApp.common.TableHeader;
import com.ubaid.elixir.elixirApp.dto.Contract;

import java.util.*;

/**
 * <p>
 * Simple Factory class which create filters
 * Filters are actually all distinct items of an column
 * for example if we have BRAND_NAME, then in the filter, we have all items of BRAND_NAME
 * </p>
 *
 * @author ubaid
 */
public class FilterFactory {
    public static Map<TableHeader, Set<String>> createFilters(List<Contract> contracts) {
        Map<TableHeader, Set<String>> filters = new HashMap<>();
        Arrays.stream(TableHeader.values()).forEach(tableHeader -> filters.put(tableHeader, new HashSet<>()));

        contracts.forEach((contract) -> Arrays.stream(TableHeader.values()).forEach(tableHeader -> {
            switch (tableHeader) {
                case BRAND_NAME -> filters.get(tableHeader).add(contract.getBrandName());
                case CONTRACT_PLAN_SEG_COMP -> filters.get(tableHeader).addAll(Arrays.asList(contract.getContractPlanSegComp()));
                case CONTRACT -> filters.get(tableHeader).add(contract.getContract());
                case PLAN_NAME -> filters.get(tableHeader).addAll(Arrays.asList(contract.getPlanNames()));
                case STATE -> filters.get(tableHeader).addAll(Arrays.asList(contract.getState()));
                case STATE_ABBREVIATION -> filters.get(tableHeader).addAll(Arrays.asList(contract.getStateAbbreviation()));
                case PRODUCT_TYPE -> filters.get(tableHeader).add(contract.getProductType());
                default -> throw new IllegalArgumentException("Table header is not present");
            }
        }));
        return filters;
    }
}
