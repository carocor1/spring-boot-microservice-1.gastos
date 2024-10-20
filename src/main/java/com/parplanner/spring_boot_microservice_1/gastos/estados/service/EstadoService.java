package com.parplanner.spring_boot_microservice_1.gastos.estados.service;

import com.parplanner.spring_boot_microservice_1.gastos.estados.dto.EstadoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.estados.model.Estado;

import java.util.List;

public interface EstadoService {

    EstadoDTO saveEstado(EstadoDTO estadoDTO);

    void deleteEstado(Long estadoId);

    List<EstadoDTO> findAllEstado();

    EstadoDTO updateEstado(Long estadoId, EstadoDTO estadoDTO);

    Estado findEstado(Long estadoId);
}
