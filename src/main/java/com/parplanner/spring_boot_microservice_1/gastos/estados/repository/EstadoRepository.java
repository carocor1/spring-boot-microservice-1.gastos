package com.parplanner.spring_boot_microservice_1.gastos.estados.repository;

import com.parplanner.spring_boot_microservice_1.gastos.estados.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
