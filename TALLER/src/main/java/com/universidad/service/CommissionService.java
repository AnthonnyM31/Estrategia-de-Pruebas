package com.universidad.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CommissionService {

    /**
     * Calcula la comisión basada en tiers:
     * - Venta <= 1,000: 0%
     * - Venta > 1,000 y <= 5,000: 10%
     * - Venta > 5,000: 20%
     */
    public BigDecimal calculateCommission(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo o nulo");
        }

        BigDecimal commissionRate;

        if (amount.compareTo(new BigDecimal("1000")) <= 0) {
            commissionRate = BigDecimal.ZERO;
        } else if (amount.compareTo(new BigDecimal("5000")) <= 0) {
            commissionRate = new BigDecimal("0.10"); // 10%
        } else {
            commissionRate = new BigDecimal("0.20"); // 20%
        }

        // Regla de Negocio: Redondear a 2 decimales usando HALF_EVEN (bancario)
        return amount.multiply(commissionRate).setScale(2, RoundingMode.HALF_EVEN);
    }
}