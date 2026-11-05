package com.softer.model;

import java.math.BigDecimal;

public class Project {

    private String code;
    private String name;
    private String clientName;
    private IndustrySector sector;
    private BigDecimal budget;
    private ProjectStatus status;

    public Project(String code, String name, String clientName, IndustrySector sector, BigDecimal budget, ProjectStatus status) {
        this.code = code;
        this.name = name;
        this.clientName = clientName;
        this.sector = sector;
        this.budget = budget;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getClientName() {
        return clientName;
    }

    public IndustrySector getSector() {
        return sector;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public ProjectStatus getStatus() {
        return status;
    }
}
