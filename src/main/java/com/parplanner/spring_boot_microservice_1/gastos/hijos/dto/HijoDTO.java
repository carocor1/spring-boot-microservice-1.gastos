package com.parplanner.spring_boot_microservice_1.gastos.hijos.dto;

import lombok.Data;

@Data
public class HijoDTO {
    private Long id; 
    private String Nombre; 
    private String apellido;
    private String fechaDeNacimiento; 
    private String provincia; 
    private String ciudad; 
    private String documento; 
    private String sexo; 

}
