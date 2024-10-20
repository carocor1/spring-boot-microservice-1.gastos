package com.parplanner.spring_boot_microservice_1.gastos.categorias.mapper;

import com.parplanner.spring_boot_microservice_1.gastos.categorias.dto.CategoriaDTO;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.model.Categoria;

public class CategoriaMapper {

    public static CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());
        return dto;
    }

    public static Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());
        return categoria;
    }
}
