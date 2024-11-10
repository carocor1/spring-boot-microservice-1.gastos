package com.parplanner.spring_boot_microservice_1.gastos.hijos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parplanner.spring_boot_microservice_1.gastos.hijos.model.Hijo;

@Repository

public interface HijoRepository extends JpaRepository<Hijo, Long>{
    
}