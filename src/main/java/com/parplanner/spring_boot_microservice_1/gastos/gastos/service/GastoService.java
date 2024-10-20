package com.parplanner.spring_boot_microservice_1.gastos.gastos.service;

import com.parplanner.spring_boot_microservice_1.gastos.gastos.dto.GastoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.model.Gasto;

import java.util.List;

public interface GastoService {

    GastoDTO saveGasto(GastoDTO gastoDTO);

    void deleteGasto(Long gastoId);

    List<GastoDTO> findAllGasto();

    GastoDTO updateGasto(Long gastoId, GastoDTO gastoDTO);

    GastoDTO findGasto(Long gastoId);

    void proponerNuevaParticion(Integer particionProgenitorCreador, Integer particionProgenitorParticipe, GastoDTO gasto);

    List<GastoDTO> findGastosByProgenitorId(Long progenitorId);
}
