package com.parplanner.spring_boot_microservice_1.gastos.progenitores.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "progenitor")
public class Progenitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    @Column(name = "cbu", length = 22, nullable = false)
    private String cbu;

    @Column(name = "fecha_de_nacimiento", nullable = false)
    private LocalDate fechaDeNacimiento;

    @Column(name = "nro_de_telefono",  nullable = false)
    private Long nroTelefono;


}