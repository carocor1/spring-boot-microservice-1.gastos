package com.parplanner.spring_boot_microservice_1.gastos.hijos.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.parplanner.spring_boot_microservice_1.gastos.hijos.dto.HijoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.hijos.model.Hijo;



public class HijoMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static HijoDTO toDTO(Hijo hijo){
        HijoDTO dto= new HijoDTO(); 
        
        dto.setId(hijo.getId());
        dto.setNombre(hijo.getNombre());
        dto.setApellido(hijo.getApellido());
        dto.setFechaDeNacimiento(hijo.getFechaDeNacimiento().format(formatter));
        dto.setProvincia(hijo.getProvincia());
        dto.setCiudad(hijo.getCiudad());
        dto.setDocumento(hijo.getDocumento()); 
        dto.setSexo(hijo.getSexo());

        return dto;

    }
    public static Hijo toEntity(HijoDTO dto) {
        Hijo hijo = new Hijo();
        hijo.setId(dto.getId());
        hijo.setNombre(dto.getNombre());
        hijo.setApellido(dto.getApellido());
        hijo.setFechaDeNacimiento(LocalDate.parse(dto.getFechaDeNacimiento(), formatter));
        hijo.setProvincia(dto.getProvincia());
        hijo.setCiudad(dto.getCiudad());
        hijo.setDocumento(dto.getDocumento());
        hijo.setSexo(dto.getSexo());
   
        return hijo;
    }

}
