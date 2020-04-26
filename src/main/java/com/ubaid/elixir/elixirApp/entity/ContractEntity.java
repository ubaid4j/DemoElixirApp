package com.ubaid.elixir.elixirApp.entity;

import com.opencsv.bean.CsvBindByName;
import com.ubaid.elixir.elixirApp.dto.Contract;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * This entity class is responsible for mapping csv file rows to its fields
 * It represent the row of csv file
 * It has method which convert this class to Data class
 * The basic different between this entity class and dto class is that, dto is pure data class
 * while it has a method which again split the attribute of this class and it is mapped to csv file
 * </p>
 *
 * @author ubaid
 */
@Data
@NoArgsConstructor
public class ContractEntity {
    @CsvBindByName(column = "contract_plan_seg_comp")
    private String contractPlanSegComp;
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

    /**
     * @return data class Contract
     */
    public Contract getContract() {
        Contract newObj = new Contract();
        newObj.setContractPlanSegComp(contractPlanSegComp.split(","));
        newObj.setContract(contract);
        newObj.setBrandName(brandName);
        newObj.setState(state.split(","));
        newObj.setStateAbbreviation(stateAbbreviation.split(","));
        newObj.setProductType(productType);
        newObj.setPlanNames(planNames.split(","));
        return newObj;
    }
}
