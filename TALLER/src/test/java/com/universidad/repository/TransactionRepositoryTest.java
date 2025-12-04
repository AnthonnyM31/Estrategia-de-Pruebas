package com.universidad.repository;

import com.universidad.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@org.springframework.test.context.ContextConfiguration(classes = Application.class)
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository repository;

    @Test
    @DisplayName("Debe encontrar transacciones dentro de un rango de fechas")
    void shouldFindTransactionsByDateRange() {
        // 1. ARRANGE (Preparar datos)
        LocalDateTime ayer = LocalDateTime.now().minusDays(1);
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime manana = LocalDateTime.now().plusDays(1);

        Transaction t1 = new Transaction(new BigDecimal("100.00"), "Pago Ayer", ayer);
        Transaction t2 = new Transaction(new BigDecimal("200.00"), "Pago Hoy", hoy);
        Transaction t3 = new Transaction(new BigDecimal("300.00"), "Pago Mañana", manana);

        repository.saveAll(List.of(t1, t2, t3));

        // 2. ACT (Ejecutar la consulta)
        // Buscamos desde el inicio de hoy hasta el final de hoy
        LocalDateTime inicioDia = LocalDateTime.now().minusHours(1); // Un poco antes de ahora
        LocalDateTime finDia = LocalDateTime.now().plusHours(1);     // Un poco después de ahora
        
        List<Transaction> result = repository.findByDateBetween(inicioDia, finDia);

        // 3. ASSERT (Verificar)
        // Debería traer solo 1 transacción (la de hoy)
        assertEquals(1, result.size());
        assertEquals("Pago Hoy", result.get(0).getDescription());
    }
    
    @Test
    @DisplayName("Debe guardar y recuperar una transacción")
    void shouldSaveAndFind() {
        Transaction t = new Transaction(new BigDecimal("500"), "Test Save", LocalDateTime.now());
        Transaction saved = repository.save(t);
        
        assertNotNull(saved.getId()); // Verifica que se generó un ID automáticamente
    }
}