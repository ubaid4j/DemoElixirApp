package com.ubaid.elixir.elixirApp.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvRecurse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contract {
    @CsvBindByName(column = "contract_plan_seg_comp")
    private String[] contractPlanSegComp;
    @CsvBindByName(column = "contract")
    private String contract;
    @CsvBindByName(column = "brand_name")
    private String brandName;
    @CsvBindByName(column = "plan_name")
    private String planNames;
    @CsvBindByName(column = "state")
    private String state;
    @CsvBindByName(column = "state_abbreviation")
    private String stateAbbreviation;
    @CsvBindByName(column = "product_type")
    private String productType;
}
