package com.parplanner.spring_boot_microservice_1.gastos.gastos.dto;
import lombok.Data;

@Data
public class GastoDTO {
    private Long id;
    private String titulo;
    private Double monto;
    private String descripcion;
    private String comprobanteCompra;
    private Long progenitorCreadorId;
    private String progenitorCreadorNombre;
    private String progenitorCreadorApellido;
    private Long progenitorParticipeId;
    private String progenitorParticipeNombre;
    private String progenitorParticipeApellido;
    private Integer particionProgenitorCreador;
    private Integer particionProgenitorParticipe;
    private Long categoriaId;
    private String nombreCategoria;
    private Long estadoId;
    private String nombreEstado;
    private String fechaCreacion;
}
