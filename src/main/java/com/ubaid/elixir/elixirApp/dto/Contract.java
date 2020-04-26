package com.ubaid.elixir.elixirApp.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Contract {
    private String[] contractPlanSegComp;
    private String contract;
    private String brandName;
    private String[] planNames;
    private String state;
    private String stateAbbreviation;
    private String productType;
}
