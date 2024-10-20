package com.parplanner.spring_boot_microservice_1.gastos.progenitores.repository;

import com.parplanner.spring_boot_microservice_1.gastos.progenitores.model.Progenitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgenitorRepository extends JpaRepository<Progenitor, Long> {
}
