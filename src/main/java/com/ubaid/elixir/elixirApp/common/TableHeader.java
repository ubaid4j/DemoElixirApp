package com.ubaid.elixir.elixirApp.common;

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

    public String getValue() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
