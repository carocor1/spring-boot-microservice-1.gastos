package com.parplanner.spring_boot_microservice_1.gastos.progenitores.service;

import com.parplanner.spring_boot_microservice_1.gastos.progenitores.dto.ProgenitorDTO;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.model.Progenitor;

import java.util.List;

public interface ProgenitorService {


    ProgenitorDTO saveProgenitor(ProgenitorDTO progenitorDTO);

    void deleteProgenitor(Long progenitorId);

    List<ProgenitorDTO> findAllProgenitor();

    ProgenitorDTO updateProgenitor(Long progenitorId, ProgenitorDTO progenitorDTO);

    Progenitor findProgenitor(Long progenitorId);
}
