package com.softer.model;

public enum ProjectStatus {
    PROPOSED("Propuesto"),
    IN_PROGRESS("En progreso"),
    COMPLETED("Completado"),
    CANCELLED("Cancelado");

    private final String description;

    ProjectStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return description;
    }
}
