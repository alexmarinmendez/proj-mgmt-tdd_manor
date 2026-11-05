package com.softer.model;

public enum IndustrySector {
    FINANCIAL("Financiero"),
    HEALTHCARE("Salud"),
    MANUFACTURING("Manufactura"),
    RETAIL("Comercio minorista"),
    TELECOMMUNICATIONS("Telecomunicaciones");

    private final String description;

    IndustrySector(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return description;
    }
}
