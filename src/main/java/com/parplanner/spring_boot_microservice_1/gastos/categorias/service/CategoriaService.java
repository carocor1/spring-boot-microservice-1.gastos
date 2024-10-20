package com.parplanner.spring_boot_microservice_1.gastos.categorias.service;

import com.parplanner.spring_boot_microservice_1.gastos.categorias.dto.CategoriaDTO;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.model.Categoria;

import java.util.List;

public interface CategoriaService {

    CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO);

    void deleteCategoria(Long categoriaId);

    List<CategoriaDTO> findAllCategoria();

    CategoriaDTO updateCategoria(Long categoriaId, CategoriaDTO categoriaDTO);

    Categoria findCategoria(Long categoriaId);
}
