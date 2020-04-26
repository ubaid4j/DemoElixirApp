package com.ubaid.elixir.elixirApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Data Transfer object which hold the each row of csv file
 * I gave it name Contract
 * </p>
 *
 * @author ubaid
 */
@NoArgsConstructor
@Data
public class Contract {
    private String[] contractPlanSegComp;
    private String contract;
    private String brandName;
    private String[] planNames;
    private String[] state;
    private String[] stateAbbreviation;
    private String productType;
}
