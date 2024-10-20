package com.parplanner.spring_boot_microservice_1.gastos.gastos.repository;

import com.parplanner.spring_boot_microservice_1.gastos.gastos.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {
     List<Gasto> findAllByProgenitorCreadorIdOrProgenitorParticipeId(Long progenitorCreadorId, Long progenitorParticipeId);
}


