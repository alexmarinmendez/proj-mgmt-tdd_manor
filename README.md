
# Sistema de Gestión de Proyectos

Aplicación de escritorio para la gestión de proyectos, desarrollada con **Java 25**, **Swing**, **Gradle 9.8.2** y **MySQL**. El proyecto aplica la metodología **Test-Driven Development (TDD)**, utilizando pruebas automatizadas para guiar el diseño, la implementación y la evolución del software.

## 🎯 Objetivo del proyecto

Desarrollar una aplicación que permita gestionar proyectos de manera eficiente, facilitando el registro, consulta, actualización y eliminación de información, así como el análisis de presupuestos según el sector industrial.

## ✨ Funcionalidades

- **Gestión de proyectos (CRUD):** registrar, consultar, actualizar y eliminar proyectos.
- **Estadísticas presupuestarias:** visualizar y analizar presupuestos agrupados por sector industrial.
- **Gestión de información:** administrar los datos de los proyectos y sus características.
- **Persistencia de datos:** almacenar y consultar información mediante una base de datos MySQL.

## 🛠️ Tecnologías utilizadas

| Tecnología | Descripción |
|---|---|
| Java 25 | Lenguaje de programación |
| Swing | Desarrollo de la interfaz gráfica de escritorio |
| Gradle 9.8.2 | Automatización de compilación y gestión de dependencias |
| MySQL | Sistema de gestión de base de datos relacional |
| JUnit 5 | Framework para pruebas automatizadas |
| Mockito | Framework para simulación de dependencias en pruebas |

## 🧪 Metodología de desarrollo: TDD

El proyecto se desarrolla siguiendo **Test-Driven Development (TDD)** o Desarrollo Dirigido por Pruebas.

Esta metodología establece que las pruebas automatizadas se escriben antes de implementar la funcionalidad correspondiente, guiando así el diseño y desarrollo del software.

Se aplica el ciclo de desarrollo **Red - Green - Refactor**:

1. 🔴 **Red:** escribir una prueba que represente el comportamiento esperado y comprobar que falla.
2. 🟢 **Green:** implementar el código mínimo necesario para que la prueba sea satisfactoria.
3. 🔵 **Refactor:** mejorar la estructura y calidad del código sin alterar su comportamiento, manteniendo todas las pruebas satisfactorias.

Este enfoque permite:

- Validar los requisitos funcionales desde las primeras etapas.
- Detectar errores tempranamente.
- Mejorar el diseño y la mantenibilidad del código.
- Reducir el riesgo de regresiones.
- Mantener una suite de pruebas automatizadas como respaldo de la funcionalidad implementada.

**Principio fundamental:** primero se define el comportamiento esperado mediante una prueba; después se implementa el código que satisface dicha prueba.

## 📋 Requisitos previos

Para ejecutar el proyecto se requiere:

- JDK 25.
- MySQL Server.
- IntelliJ IDEA (recomendado).
- Gradle 9.8.2 o el Gradle Wrapper incluido en el repositorio.

## ⚙️ Configuración de la base de datos

1. Instalar e iniciar MySQL Server.
2. Crear la base de datos que utilizará la aplicación.
3. Ejecutar el script `schema.sql` para preparar la estructura de la base de datos.
4. Configurar las siguientes variables de entorno:

| Variable | Descripción |
|---|---|
| `MYSQLDB_URL` | URL de conexión JDBC a MySQL |
| `MYSQLDB_USERNAME` | Usuario de conexión a MySQL |
| `MYSQLDB_PASSWORD` | Contraseña del usuario de MySQL |

Ejemplo de URL de conexión:

```properties
jdbc:mysql://localhost:3306/nombre_de_base_de_datos
```

La aplicación utiliza estas variables para configurar las propiedades de conexión:

- `db.url`
- `db.username`
- `db.password`

**Importante:** no almacenar credenciales reales directamente en el código fuente ni publicarlas en el repositorio.

## ▶️ Compilación y ejecución de pruebas

Desde la raíz del proyecto, utilizar los siguientes comandos:

**Windows:**

```bash
gradlew.bat clean build
```

Ejecutar únicamente las pruebas:

```bash
gradlew.bat test
```

**Linux / macOS:**

```bash
./gradlew clean build
```

Ejecutar únicamente las pruebas:

```bash
./gradlew test
```

La tarea `test` ejecuta las pruebas automatizadas del proyecto, mientras que `build` realiza la compilación y las verificaciones configuradas en Gradle.

## 📁 Estructura del proyecto

```text
project-management/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ...
│   │
│   └── test/
│       └── java/
│           └── ...
│
├── gradle/
├── gradlew
├── gradlew.bat
├── build.gradle
├── settings.gradle
├── schema.sql
└── README.md
```

- `src/main/`: contiene el código fuente de la aplicación.
- `src/test/`: contiene las pruebas automatizadas.
- `gradle/`: contiene los archivos de configuración del Gradle Wrapper.
- `build.gradle`: define las dependencias y tareas de construcción.
- `settings.gradle`: configura el proyecto Gradle.
- `schema.sql`: contiene el script de creación de la estructura de la base de datos.

## 🚀 Ejecución de la aplicación

1. Clonar el repositorio.
2. Configurar la conexión con MySQL.
3. Abrir el proyecto en IntelliJ IDEA.
4. Verificar que se esté utilizando JDK 25.
5. Sincronizar las dependencias de Gradle.
6. Ejecutar las pruebas automatizadas.
7. Ejecutar la clase principal de la aplicación.

## 🎓 Propósito del desarrollo

Este proyecto busca aplicar buenas prácticas de ingeniería de software mediante el uso de TDD, promoviendo un desarrollo incremental, verificable y orientado a la calidad.

La implementación de cada funcionalidad está respaldada por pruebas automatizadas, convirtiendo las pruebas en una parte fundamental del proceso de diseño y construcción del software.
