# 🏛️ Tarea de Arquitectura de Software: Estrategia de Pruebas

Este repositorio contiene la resolución completa de los ejercicios prácticos de Pruebas de Software, migrando un sistema legado a una arquitectura moderna basada en **Spring Boot** y aplicando tres niveles de testing: Unitario, Integración y Contrato.

## 📖 Historia del Desarrollo

El proyecto comenzó como una aplicación de consola en Java estándar (Legacy), con una estructura de archivos plana y gestión manual de dependencias. Para cumplir con los requisitos de arquitectura moderna y pruebas automatizadas, realizamos una **reingeniería completa** en varias fases:

1.  **Migración a Maven y Spring Boot:** Transformamos el proyecto para usar gestión de dependencias y la estructura estándar (`src/main` y `src/test`).
2.  **Refactorización de Paquetes:** Corregimos la deuda técnica de los nombres de paquetes (el problema `package main.java...`) para alinearlos con los estándares de la industria (`com.universidad...`).
3.  **Implementación de Capas:** Separamos la lógica en Servicios (`Service`), Repositorios (`Repository`) y Controladores (`Controller`).

---

## 🧪 Ejercicios Desarrollados

### 🟢 Ejercicio A: Pruebas Unitarias & Mutation Testing
**Objetivo:** Validar lógica de negocio pura sin dependencias externas.
- **Componente:** `CommissionService`.
- **Lógica:** Cálculo de comisiones basado en tiers (0%, 10%, 20%) y redondeo bancario.
- **Tecnologías:** JUnit 5, Mockito.
- **Calidad:** Se aplicó **Mutation Testing con PIT**, logrando una cobertura del 100% y eliminando mutantes (código resistente a sabotajes).

### 🔵 Ejercicio B: Pruebas de Integración con Base de Datos
**Objetivo:** Validar la persistencia y consultas personalizadas.
- **Componente:** `TransactionRepository`.
- **Lógica:** Consultas JPQL para filtrar transacciones por rangos de fecha.
- **Tecnologías:** Spring Data JPA, H2 Database (simulando entorno real), Hibernate.
- **Validación:** Se verificó la creación automática de tablas y la integridad de los datos guardados.

### 🟣 Ejercicio C: Pruebas de Contrato (Contract Testing)
**Objetivo:** Garantizar la comunicación entre microservicios (Consumer-Driven Contracts).
- **Componente:** `PaymentController` (API REST).
- **Escenario:** Validación del endpoint `/payments/authorize`.
- **Tecnologías:** Pact JVM (JUnit 5), Pact V4.
- **Resultado:** Generación exitosa del contrato `.json` que asegura que el Frontend y Backend se entienden.

---

## 🛠️ Tecnologías Utilizadas

* **Java:** 17+
* **Framework:** Spring Boot 3.2.0
* **Build Tool:** Maven
* **Testing:** JUnit 5, Mockito, Spring Boot Test
* **DB Testing:** H2 Database
* **Mutation Testing:** PIT (Pitest)
* **Contract Testing:** Pact JVM Consumer V4

---

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos
* Tener Java 17 o superior instalado.
* VS Code con el "Extension Pack for Java".

### Pasos
1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/AnthonnyM31/Estrategia-de-Pruebas.git](https://github.com/AnthonnyM31/Estrategia-de-Pruebas.git)
    ```
2.  **Limpiar y Compilar:**
    En VS Code, presiona `Ctrl + Shift + P` y selecciona `Java: Clean Java Language Server Workspace`.
3.  **Ejecutar Pruebas:**
    * Ve a la pestaña de "Testing" (icono del matraz 🧪) en VS Code.
    * Ejecuta las pruebas individualmente (`CommissionServiceTest`, `TransactionRepositoryTest`, `PaymentContractTest`) o corre todas juntas.

---

## ⚠️ Dificultades y Soluciones (Troubleshooting)

Durante el desarrollo enfrentamos varios desafíos técnicos interesantes:

### 1. El Problema de la Ubicación de los Tests
* **Error:** `org.junit cannot be resolved`.
* **Causa:** Inicialmente, los archivos de prueba se crearon dentro de `src/main/java`. Maven es estricto y solo permite librerías de test en `src/test/java`.
* **Solución:** Mover físicamente los archivos a la carpeta `test` y actualizar los imports.

### 2. Conflicto de Nombres de Paquete
* **Error:** `The declared package "main.java..." does not match...`
* **Causa:** Al migrar los archivos manuales, conservaron la ruta `main.java.` en la declaración del paquete.
* **Solución:** Refactorización masiva en todos los archivos POJO (`Alumno`, `Persona`, etc.) para usar `package com.universidad...`.

### 3. Entorno de Laboratorio vs. Personal
* **Reto:** Restricciones de red y falta de binarios de Maven en el `PATH` de las computadoras de laboratorio.
* **Solución:** Configuramos el proyecto para utilizar el Maven Wrapper (`mvnw`) integrado en VS Code, permitiendo la ejecución de pruebas sin instalaciones globales.

### 4. Pact V3 vs V4
* **Error:** `UnsupportedOperationException: Method createPact does not conform...`
* **Causa:** La librería moderna de Pact exigía el estándar V4, pero la implementación inicial usaba V3.
* **Solución:** Actualizar la firma del método `createPact` para devolver un objeto `V4Pact` y usar `builder.usingLegacyDsl()...toPact(V4Pact.class)`.

### 5. Git Dubious Ownership
* **Error:** Bloqueo de Git por permisos de usuario en Windows.
* **Solución:** Ejecutar `git config --global --add safe.directory` para autorizar la carpeta del proyecto.

---

**Autores:** [Anthonny Mosquera, Mateo Coronel, David Puga]
**Materia:** Arquitectura y Diseño de Software