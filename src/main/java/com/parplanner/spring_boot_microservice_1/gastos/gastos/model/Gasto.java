package com.parplanner.spring_boot_microservice_1.gastos.gastos.model;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.model.Categoria;
import com.parplanner.spring_boot_microservice_1.gastos.estados.model.Estado;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.model.Progenitor;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
@Data
@Entity
@Table(name = "gasto")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "comprobante_compra", length = 1200, nullable = false)
    private String comprobanteCompra;

    @ManyToOne // Relación con Progenitor
    @JoinColumn(name = "progenitor_creador_id", nullable = false)
    private Progenitor progenitorCreador;

    @ManyToOne // Relación con Progenitor
    @JoinColumn(name = "progenitor_participe_id", nullable = false)
    private Progenitor progenitorParticipe;

    @Column(name = "particion_progenitor_creador", length = 3, nullable = false)
    private Integer particionProgenitorCreador;

    @Column(name = "particion_progenitor_participe", length = 3, nullable = false)
    private Integer particionProgenitorParticipe;

    @ManyToOne // Relación con Categoria
    @JoinColumn(name = "categoria_id", nullable = false) // La columna en la tabla de gasto
    private Categoria categoria;

    @ManyToOne // Relación con Estado
    @JoinColumn(name = "estado_id", nullable = false) // La columna en la tabla de gasto
    private Estado estado;

    @Column(name = "fecha_de_creacion", nullable = false)
    private LocalDate fechaCreacion;
}
