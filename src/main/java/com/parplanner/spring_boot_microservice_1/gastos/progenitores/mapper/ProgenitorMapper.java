package com.parplanner.spring_boot_microservice_1.gastos.progenitores.mapper;

import com.parplanner.spring_boot_microservice_1.gastos.progenitores.dto.ProgenitorDTO;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.model.Progenitor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProgenitorMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static ProgenitorDTO toDTO(Progenitor progenitor) {
        ProgenitorDTO dto = new ProgenitorDTO();
        dto.setId(progenitor.getId());
        dto.setNombre(progenitor.getNombre());
        dto.setApellido(progenitor.getApellido());
        dto.setCbu(progenitor.getCbu());
        dto.setFechaDeNacimiento(progenitor.getFechaDeNacimiento().format(formatter));
        dto.setNroTelefono(progenitor.getNroTelefono());
        return dto;
    }

    public static Progenitor toEntity(ProgenitorDTO dto) {
        Progenitor progenitor = new Progenitor();
        progenitor.setId(dto.getId());
        progenitor.setNombre(dto.getNombre());
        progenitor.setApellido(dto.getApellido());
        progenitor.setCbu(dto.getCbu());
        progenitor.setFechaDeNacimiento(LocalDate.parse(dto.getFechaDeNacimiento(), formatter));
        progenitor.setNroTelefono(dto.getNroTelefono());
        return progenitor;
    }
}