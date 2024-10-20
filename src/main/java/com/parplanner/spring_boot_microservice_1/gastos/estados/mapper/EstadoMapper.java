package com.parplanner.spring_boot_microservice_1.gastos.estados.mapper;

import com.parplanner.spring_boot_microservice_1.gastos.estados.dto.EstadoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.estados.model.Estado;

public class EstadoMapper {

    public static EstadoDTO toDTO(Estado estado) {
        EstadoDTO dto = new EstadoDTO();
        dto.setId(estado.getId());
        dto.setNombre(estado.getNombre());
        return dto;
    }

    public static Estado toEntity(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setId(dto.getId());
        estado.setNombre(dto.getNombre());
        return estado;
    }
}
