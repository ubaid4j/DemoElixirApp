package com.ubaid.elixir.elixirApp.common;

/**
 * <p>
 *     It represents the header of table
 * </p>
 *
 * @author Ubaid ur Rehman
 */
public enum TableHeader {

    CONTRACT_PLAN_SEG_COMP("contract_plan_seg_comp"),
    CONTRACT("contract"),
    BRAND_NAME("brand_name"),
    PLAN_NAME("plan_name"),
    STATE("state"),
    STATE_ABBREVIATION("state_abbreviation"),
    PRODUCT_TYPE("product_type");

    private final String label;

    TableHeader(String name) {
        this.label = name;
    }

    @Override
    public String toString() {
        return label;
    }
}
