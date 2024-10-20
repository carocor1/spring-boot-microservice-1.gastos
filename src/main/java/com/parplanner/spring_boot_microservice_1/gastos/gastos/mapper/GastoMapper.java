package com.parplanner.spring_boot_microservice_1.gastos.gastos.mapper;

import com.parplanner.spring_boot_microservice_1.gastos.categorias.repository.CategoriaRepository;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.dto.GastoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.model.Gasto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GastoMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    private CategoriaRepository categoriaRepository;

    public static GastoDTO toDTO(Gasto gasto) {
        GastoDTO dto = new GastoDTO();
        dto.setId(gasto.getId());
        dto.setTitulo(gasto.getTitulo());
        dto.setMonto(gasto.getMonto());
        dto.setDescripcion(gasto.getDescripcion());
        dto.setComprobanteCompra(gasto.getComprobanteCompra());
        dto.setProgenitorCreadorId(gasto.getProgenitorCreador().getId());
        dto.setProgenitorParticipeId(gasto.getProgenitorParticipe().getId());
        dto.setProgenitorCreadorNombre(gasto.getProgenitorCreador().getNombre());
        dto.setProgenitorCreadorApellido(gasto.getProgenitorCreador().getApellido());
        dto.setProgenitorParticipeNombre(gasto.getProgenitorParticipe().getNombre());
        dto.setProgenitorParticipeApellido(gasto.getProgenitorParticipe().getApellido());
        dto.setNombreCategoria(gasto.getCategoria().getNombre());
        dto.setNombreEstado(gasto.getEstado().getNombre());
        dto.setFechaCreacion(gasto.getFechaCreacion().format(formatter));
        dto.setParticionProgenitorCreador(gasto.getParticionProgenitorCreador());
        dto.setParticionProgenitorParticipe(gasto.getParticionProgenitorParticipe());
        dto.setEstadoId(gasto.getEstado().getId());
        dto.setCategoriaId(gasto.getCategoria().getId());
        return dto;
    }

    public static Gasto toEntity(GastoDTO dto) {
        Gasto gasto = new Gasto();
        gasto.setId(dto.getId());
        gasto.setTitulo(dto.getTitulo());
        gasto.setMonto(dto.getMonto());
        gasto.setDescripcion(dto.getDescripcion());
        gasto.setComprobanteCompra(dto.getComprobanteCompra());
        gasto.setFechaCreacion(LocalDate.parse(dto.getFechaCreacion(), formatter));
        gasto.setParticionProgenitorCreador(dto.getParticionProgenitorCreador());
        gasto.setParticionProgenitorParticipe(dto.getParticionProgenitorParticipe());
        return gasto;
    }
}

