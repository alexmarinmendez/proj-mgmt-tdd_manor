# Especificación formal de pruebas de software

**Proyecto Java:** PROJ-MGMT  
**Enfoque de desarrollo:** Test Driven Development (TDD)  
**Institución:** CIBERTEC  
**Tipo de documento:** Documento de trabajo técnico  
**Fecha:** 05 de noviembre de 2026

## Identificación

| Identificación | Detalle |
|---|---|
| Proyecto | `proj-mgmt` - gestión de proyectos |
| Tecnología | Java, Gradle y JUnit 6 |
| Versión del documento | 1.0 |
| Fecha | 05 de noviembre de 2026 |

> Documento técnico para orientar la implementación incremental del software mediante pruebas.

## 1. Propósito

Este documento define los escenarios de prueba que deben guiar la evolución del proyecto PROJ-MGMT mediante TDD. La especificación propone pruebas para cubrir reglas actuales, límites, entradas inválidas y comportamientos que deberán definirse antes de implementar el dominio.

El propósito no es elaborar primero toda la solución y comprobarla al final, sino convertir cada comportamiento esperado en una prueba ejecutable antes de implementar o modificar el código de producción.

## 2. Enfoque de trabajo: ciclo TDD

| Fase | Actividad | Criterio de avance |
|---|---|---|
| RED (Rojo) | Escribir una prueba pequeña que describa una regla todavía no implementada y ejecutarla. | La prueba falla por la razón esperada, no por errores de compilación o configuración. |
| GREEN (Verde) | Implementar el mínimo código necesario para satisfacer esa prueba. | La nueva prueba pasa y las pruebas anteriores siguen pasando. |
| REFACTOR (Refactorizar) | Mejorar el diseño sin cambiar el comportamiento observable. | Toda la suite continúa pasando. |

Cada caso de prueba debe desarrollarse de forma incremental. No se debe implementar todas las validaciones y después escribir una batería de pruebas, porque eso reproduce el enfoque tradicional que se desea reemplazar.

La secuencia de ejecución de los tests no debe utilizarse como mecanismo de dependencia entre pruebas. Cada prueba debe ser independiente y producir el mismo resultado aunque JUnit la ejecute en otro orden.

## 3. Catálogo de pruebas obligatorias

| ID | Prueba / comportamiento | Resultado esperado |
|---|---|---|
| PRJ-001 | Crear proyecto con datos válidos. | Instancia creada y getters devuelven los valores recibidos. |
| PRJ-002 | Crear proyecto sin código (`null`). | Lanzar `IllegalArgumentException`. |
| PRJ-003 | Crear proyecto sin nombre (`null`). | Lanzar `IllegalArgumentException`. |
| PRJ-004 | Crear proyecto con presupuesto negativo. | Lanzar `IllegalArgumentException`. |
| PRJ-005 | Crear proyecto con presupuesto igual a cero. | Lanzar `IllegalArgumentException`. |
| PRJ-006 | Crear proyecto con estado `null`. | Asignar `ProjectStatus.PROPOSED`. |

## 4. Catálogo de pruebas adicionales para el dominio

Los siguientes casos amplían la cobertura del comportamiento actual. Los resultados esperados constituyen la especificación propuesta; cuando una regla no está definida explícitamente en el código, se señala como decisión de negocio pendiente.

| ID | Escenario | Resultado esperado / regla |
|---|---|---|
| PRJ-007 | Código vacío: `""`. | Rechazar con `IllegalArgumentException`. |
| PRJ-008 | Código compuesto solo por espacios. | Rechazar con `IllegalArgumentException`. |
| PRJ-009 | Nombre vacío: `""`. | Rechazar con `IllegalArgumentException`. |
| PRJ-010 | Nombre compuesto solo por espacios. | Rechazar con `IllegalArgumentException`. |
| PRJ-011 | Presupuesto `null`. | Rechazar de forma controlada con `IllegalArgumentException`; no permitir que se produzca `NullPointerException`. |
| PRJ-012 | Presupuesto positivo mínimo definido por el dominio, por ejemplo, `0.01`. | Aceptar el proyecto si el dominio admite dos decimales y no existe un mínimo superior. |
| PRJ-013 | Presupuesto positivo con decimales. | Aceptar y conservar el valor numérico sin pérdida de precisión. |
| PRJ-014 | Presupuesto positivo de importe elevado. | Aceptar si no existe un máximo de negocio establecido. |
| PRJ-015 | Cliente `null` o en blanco. | Definir primero si `clientName` es obligatorio. Si lo es, rechazar; si es opcional, aceptar y conservar `null`/vacío según la regla acordada. |
| PRJ-016 | Sector `null`. | Definir si `sector` es obligatorio. Si lo es, rechazar con `IllegalArgumentException`; si es opcional, aceptar. |
| PRJ-017 | Estado explícito `IN_PROGRESS`. | Conservar `ProjectStatus.IN_PROGRESS`. |
| PRJ-018 | Estado explícito `COMPLETED`. | Conservar `ProjectStatus.COMPLETED`. |
| PRJ-019 | Estado explícito `CANCELLED`. | Conservar `ProjectStatus.CANCELLED`. |
| PRJ-020 | Estado explícito `PROPOSED`. | Conservar `ProjectStatus.PROPOSED`. |
| PRJ-021 | Verificar todos los datos después de construir el objeto. | Cada getter devuelve el dato correspondiente; no hay intercambio de atributos. |

## 5. Pruebas de los enums y sus descripciones

Los enums incorporan descripciones en español. Conviene verificar este contrato para evitar que la interfaz muestre los identificadores técnicos en inglés cuando corresponda presentar el texto amigable.

| ID | Elemento | Resultado esperado |
|---|---|---|
| ENUM-001 | `ProjectStatus.PROPOSED.getDescription()` | `"Propuesto"`. |
| ENUM-002 | `ProjectStatus.IN_PROGRESS.getDescription()` | `"En progreso"`. |
| ENUM-003 | `ProjectStatus.COMPLETED.getDescription()` | `"Completado"`. |
| ENUM-004 | `ProjectStatus.CANCELLED.getDescription()` | `"Cancelado"`. |
| ENUM-005 | `IndustrySector.FINANCIAL.getDescription()` | `"Financiero"`. |
| ENUM-006 | `IndustrySector.HEALTHCARE.getDescription()` | `"Salud"`. |
| ENUM-007 | `IndustrySector.MANUFACTURING.getDescription()` | `"Manufactura"`. |
| ENUM-008 | `IndustrySector.RETAIL.getDescription()` | `"Comercio minorista"`. |
| ENUM-009 | `IndustrySector.TELECOMMUNICATIONS.getDescription()` | `"Telecomunicaciones"`. |
| ENUM-010 | `toString()` de cada valor de ambos enumerados. | Devolver la misma descripción en español que `getDescription()`. |

## 6. Pruebas futuras por capas

### 6.1. Servicios de negocio (cuando se incorporen)

| ID | Escenario propuesto | Resultado esperado |
|---|---|---|
| SRV-001 | Registrar un proyecto válido. | El servicio solicita la persistencia y devuelve el proyecto registrado. |
| SRV-002 | Registrar un proyecto con código duplicado. | Rechazar la operación con una excepción o resultado de dominio definido. |
| SRV-003 | Buscar un proyecto por código existente. | Devolver el proyecto correspondiente. |
| SRV-004 | Buscar un proyecto por código inexistente. | Devolver ausencia controlada, por ejemplo, `Optional` vacío, o error de negocio definido. |
| SRV-005 | Actualizar un proyecto existente. | Persistir los cambios permitidos y conservar los campos no modificados. |
| SRV-006 | Actualizar un proyecto inexistente. | Informar que el proyecto no existe; no crear uno accidentalmente. |
| SRV-007 | Eliminar un proyecto existente. | Eliminarlo según la política definida y confirmar el resultado. |
| SRV-008 | Cambiar estado del proyecto. | Permitir únicamente transiciones autorizadas por las reglas de negocio. |

### 6.2. Repositorio y base de datos (cuando se incorporen)

| ID | Escenario propuesto | Resultado esperado |
|---|---|---|
| REP-001 | Guardar un proyecto válido. | Registro almacenado con todos sus atributos. |
| REP-002 | Consultar por código. | Mapeo correcto entre columnas y propiedades Java. |
| REP-003 | Guardar y recuperar `BigDecimal`. | Importe recuperado sin pérdida de precisión. |
| REP-004 | Guardar y recuperar los enumerados. | Persistencia y lectura consistentes con la estrategia elegida, nombre o código. |
| REP-005 | Código duplicado. | La restricción de unicidad se respeta y el error se traduce adecuadamente. |
| REP-006 | Operación dentro de transacción que falla. | Se revierte la operación según la política transaccional. |

## 7. Criterios de calidad para cada prueba

- Debe verificar un comportamiento observable y una regla concreta; evitar pruebas que solo repitan la implementación.
- Debe ser independiente, determinista y ejecutable de forma aislada.
- Debe tener un nombre descriptivo y un `@DisplayName` en español que exprese el resultado esperado.
- Debe comprobar el resultado correcto y, cuando aplique, el tipo de excepción y el mensaje de validación.
- Debe utilizar datos explícitos y legibles. Para `BigDecimal`, construir valores desde `String` y comparar numéricamente cuando la escala no forme parte de la regla.
- Debe evitar depender del orden de ejecución de otros tests.
- Debe ejecutarse junto con la suite completa después de cada cambio de producción.
- Debe incluir casos válidos, inválidos y límites relevantes; no es necesario probar todas las combinaciones posibles sin justificación.

## 8. Condiciones de aceptación de esta especificación

El componente `Project` se considerará cubierto respecto de esta especificación cuando:

- Todos los casos definidos como obligatorios estén automatizados y pasen.
- Las decisiones pendientes sobre `clientName` y `sector` estén documentadas y sus pruebas reflejen la decisión adoptada.
- Los datos inválidos produzcan respuestas controladas, sin excepciones accidentales.
- Las pruebas de los enumerados confirmen las descripciones en español.
- La suite completa se ejecute correctamente mediante Gradle y JUnit Platform.
- Los cambios de implementación se hayan realizado siguiendo el ciclo RED-GREEN-REFACTOR.

## 9. Ejecución de las pruebas

Desde la raíz del proyecto, ejecutar la suite con el wrapper de Gradle:

```powershell
.\gradlew test
```

En Windows también puede ejecutarse desde IntelliJ IDEA mediante la clase `ProjectTest` o desde la ventana Gradle. La ejecución debe finalizar sin pruebas fallidas.

El reporte HTML de Gradle se genera normalmente en:

```text
build/reports/tests/test/index.html
```
