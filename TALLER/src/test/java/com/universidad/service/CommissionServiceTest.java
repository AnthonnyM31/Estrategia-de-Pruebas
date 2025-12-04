package com.universidad.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CommissionServiceTest {

    private final CommissionService service = new CommissionService();

    @Test
    @DisplayName("Debe lanzar excepción si el monto es negativo")
    void shouldThrowExceptionForNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateCommission(new BigDecimal("-100"));
        });
    }

    @ParameterizedTest(name = "Monto {0} debe dar comision {1}")
    @CsvSource({
        "500.00, 0.00",    // Tier 1: Dentro del rango
        "1000.00, 0.00",   // Tier 1: Limite superior exacto
        "1000.01, 100.00", // Tier 2: Limite inferior inmediato (10% de 1000.01 es 100.00)
        "2500.00, 250.00", // Tier 2: Dentro del rango
        "5000.00, 500.00", // Tier 2: Limite superior exacto
        "5000.01, 1000.00",// Tier 3: Limite inferior inmediato (20%)
        "10000.00, 2000.00"// Tier 3: Normal
    })
    void testBoundariesAndTiers(String amountStr, String expectedCommissionStr) {
        // Arrange
        BigDecimal amount = new BigDecimal(amountStr);
        BigDecimal expected = new BigDecimal(expectedCommissionStr);

        // Act
        BigDecimal result = service.calculateCommission(amount);

        // Assert
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Prueba de redondeo bancario")
    void testRounding() {
        // 1234.56 * 0.10 = 123.456 -> debe redondear a 123.46
        BigDecimal amount = new BigDecimal("1234.56");
        BigDecimal expected = new BigDecimal("123.46");
        
        assertEquals(expected, service.calculateCommission(amount));
    }
}