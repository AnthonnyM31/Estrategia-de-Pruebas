package com.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Spring Data crea la consulta automáticamente por el nombre del método
    List<Transaction> findByDateBetween(LocalDateTime start, LocalDateTime end);

    // O podemos hacerlo manualmente con JPQL (Opcional, pero bueno para aprender)
    @Query("SELECT t FROM Transaction t WHERE t.amount > :minAmount")
    List<Transaction> findLargeTransactions(@Param("minAmount") java.math.BigDecimal minAmount);
}