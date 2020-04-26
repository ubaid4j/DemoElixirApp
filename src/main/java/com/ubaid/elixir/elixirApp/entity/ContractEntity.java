package com.ubaid.elixir.elixirApp.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvRecurse;
import com.ubaid.elixir.elixirApp.dto.Contract;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractEntity {
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

    public Contract getContract() {
        Contract newObj = new Contract();
        newObj.setContractPlanSegComp(contractPlanSegComp);
        newObj.setContract(contract);
        newObj.setBrandName(brandName);
        newObj.setState(state);
        newObj.setStateAbbreviation(stateAbbreviation);
        newObj.setProductType(productType);
        newObj.setPlanNames(planNames.split(","));
        return  newObj;
    }
}
