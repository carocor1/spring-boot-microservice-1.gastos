package com.parplanner.spring_boot_microservice_1.gastos.categorias.service;

import com.parplanner.spring_boot_microservice_1.gastos.categorias.dto.CategoriaDTO;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.mapper.CategoriaMapper;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.model.Categoria;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaMapper.toEntity(categoriaDTO);
        return CategoriaMapper.toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public void deleteCategoria(Long categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

    @Override
    public List<CategoriaDTO> findAllCategoria() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO updateCategoria(Long categoriaId, CategoriaDTO categoriaDTO) {
        Categoria existingCategoria = this.findCategoria(categoriaId);
        if (categoriaDTO.getNombre() != null) {
            existingCategoria.setNombre(categoriaDTO.getNombre());
        }
        return CategoriaMapper.toDTO(categoriaRepository.save(existingCategoria));
    }

    @Override
    public Categoria findCategoria(Long categoriaId) {
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }
}
