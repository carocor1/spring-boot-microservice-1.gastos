package com.parplanner.spring_boot_microservice_1.gastos.progenitores.dto;
import lombok.Data;


@Data
public class ProgenitorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String cbu;
    private String fechaDeNacimiento; // Como cadena de texto en formato DD/MM/YYYY
    private Long nroTelefono;
}