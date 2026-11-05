package com.softer.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProjectTest {

    @Test
    void shouldCreateProjectWithValidData() {
        Project project = new Project(
                "PRJ-001",
                "Sistema de ventas",
                "Cliente ABC",
                IndustrySector.RETAIL,
                new BigDecimal("150000.00"),
                ProjectStatus.PROPOSED
        );
        assertNotNull(project);
        assertEquals("PRJ-001", project.getCode());
        assertEquals("Sistema de ventas", project.getName());
        assertEquals("Cliente ABC", project.getClientName());
        assertEquals(IndustrySector.RETAIL, project.getSector());
        assertEquals(0, new BigDecimal("150000.00").compareTo(project.getBudget()));
        assertEquals(ProjectStatus.PROPOSED, project.getStatus());
    }

}