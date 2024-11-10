package com.parplanner.spring_boot_microservice_1.gastos.hijos.service;

import java.util.List;

import com.parplanner.spring_boot_microservice_1.gastos.hijos.dto.HijoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.hijos.model.Hijo;




public interface HijoService {


    HijoDTO saveHijo(HijoDTO hijoDTO);

    void deleteHijo(Long hijoId);

    List<HijoDTO> findAllHijo();

    HijoDTO updateHijo(Long hijoId, HijoDTO hijoDTO);

    Hijo findHijo(Long hijoId);
    
}
