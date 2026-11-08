package com.softer.model;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjectTest {

    @Test
    @Order(1)
    @DisplayName("Debe crear un proyecto cuando todos los datos son válidos")
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

    @Test
    @Order(2)
    @DisplayName("Debe rechazar un proyecto sin código")
    void shouldRejectProjectWithoutCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Project(
                    null,
                    "Sistema de ventas",
                    "Cliente ABC",
                    IndustrySector.RETAIL,
                    new BigDecimal("150000.00"),
                    ProjectStatus.PROPOSED
            );
        });
    }

    @Test
    @Order(3)
    @DisplayName("Debe rechazar un proyecto con código vacío")
    void shouldRejectProjectWithBlankCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Project(
                    "",
                    "Sistema de ventas",
                    "Cliente ABC",
                    IndustrySector.RETAIL,
                    new BigDecimal("150000.00"),
                    ProjectStatus.PROPOSED
            );
        });
    }

    @Test
    @Order(4)
    @DisplayName("Debe rechazar un proyecto sin nombre")
    void shouldRejectProjectWithoutName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Project(
                    "PRJ-001",
                    null,
                    "Cliente ABC",
                    IndustrySector.RETAIL,
                    new BigDecimal("150000.00"),
                    ProjectStatus.PROPOSED
            );
        });
    }

    @Test
    @Order(5)
    @DisplayName("Debe rechazar un proyecto con nombre vacío")
    void shouldRejectProjectWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Project(
                    "PRJ-001",
                    "",
                    "Cliente ABC",
                    IndustrySector.RETAIL,
                    new BigDecimal("150000.00"),
                    ProjectStatus.PROPOSED
            );
        });
    }

    @Test
    @Order(6)
    @DisplayName("Debe rechazar un proyecto con presupuesto menor a cero")
    void shouldRejectProjectWithNegativeBudget() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Project(
                    "PRJ-001",
                    "Sistema de ventas",
                    "Cliente ABC",
                    IndustrySector.RETAIL,
                    new BigDecimal("-150000.00"),
                    ProjectStatus.PROPOSED
            );
        });
    }

    @Test
    @Order(7)
    @DisplayName("Debe rechazar un proyecto con presupuesto igual a cero")
    void shouldRejectProjectWithZeroBudget() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Project(
                    "PRJ-001",
                    "Sistema de ventas",
                    "Cliente ABC",
                    IndustrySector.RETAIL,
                    BigDecimal.ZERO, //new BigDecimal("0.00")
                    ProjectStatus.PROPOSED
            );
        });
    }

    @Test
    @Order(8)
    @DisplayName("Debe asignar PROPOSED cuando el estado del proyecto es null")
    void shouldAssignProposedStatusWhenStatusIsNull() {
        Project project = new Project(
                "PRJ-001",
                "Sistema de ventas",
                "Cliente ABC",
                IndustrySector.RETAIL,
                new BigDecimal("150000.00"),
                null
        );

        assertEquals(ProjectStatus.PROPOSED, project.getStatus());
    }

}