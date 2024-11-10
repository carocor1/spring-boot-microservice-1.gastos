package com.parplanner.spring_boot_microservice_1.gastos.hijos.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table (name="hijo")
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombre",length = 100,nullable = false)
    private String nombre;

    @Column (name="apellido", length=100,nullable =false)
    private String apellido;

    @Column(name="fechaDeNacimiento", length =20, nullable = false)
    private LocalDate fechaDeNacimiento; 
    
    @Column (name="provincia", length=100, nullable=false)
    private String provincia; 

    @Column (name="ciudad", length =100, nullable=false)
    private String ciudad; 

    @Column (name="documento" ,length=100, nullable =false)
    private String documento; 
    @Column (name="sexo", length=100, nullable=false)
    private String sexo;

    
}
