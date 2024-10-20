package com.parplanner.spring_boot_microservice_1.gastos.gastos.service;

import com.parplanner.spring_boot_microservice_1.gastos.categorias.repository.CategoriaRepository;
import com.parplanner.spring_boot_microservice_1.gastos.estados.repository.EstadoRepository;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.dto.GastoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.mapper.GastoMapper;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.model.Gasto;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.repository.GastoRepository;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.repository.ProgenitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private ProgenitorRepository progenitorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public GastoDTO saveGasto(GastoDTO gastoDTO) {
        gastoDTO.setFechaCreacion(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        gastoDTO.setEstadoId(2L);
        Gasto gasto = GastoMapper.toEntity(gastoDTO);
        gasto.setProgenitorCreador(progenitorRepository.findById(gastoDTO.getProgenitorCreadorId())
                .orElseThrow(() -> new RuntimeException("Progenitor creador no encontrado")));
        gasto.setProgenitorParticipe(progenitorRepository.findById(gastoDTO.getProgenitorParticipeId())
                .orElseThrow(() -> new RuntimeException("Progenitor partícipe no encontrado")));
        gasto.setCategoria(categoriaRepository.findById(gastoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada")));
        gasto.setEstado(estadoRepository.findById(gastoDTO.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado")));

        return GastoMapper.toDTO(gastoRepository.save(gasto));
    }


    @Override
    public void deleteGasto(Long gastoId) {
        gastoRepository.deleteById(gastoId);
    }

    @Override
    public List<GastoDTO> findAllGasto() {
        return gastoRepository.findAll().stream()
                .map(GastoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GastoDTO updateGasto(Long gastoId, GastoDTO gastoDTO) {
        Gasto existingGasto = gastoRepository.findById(gastoId)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));
        if (gastoDTO.getTitulo() != null) {
            existingGasto.setTitulo(gastoDTO.getTitulo());
        }
        if (gastoDTO.getMonto() != null) {
            existingGasto.setMonto(gastoDTO.getMonto());
        }
        if (gastoDTO.getDescripcion() != null) {
            existingGasto.setDescripcion(gastoDTO.getDescripcion());
        }
        if (gastoDTO.getComprobanteCompra() != null) {
            existingGasto.setComprobanteCompra(gastoDTO.getComprobanteCompra());
        }
        if (gastoDTO.getProgenitorCreadorId() != null) {
            existingGasto.setProgenitorCreador(progenitorRepository.findById(gastoDTO.getProgenitorCreadorId())
                    .orElseThrow(() -> new RuntimeException("Progenitor creador no encontrado")));
        }
        if (gastoDTO.getProgenitorParticipeId() != null) {
            existingGasto.setProgenitorParticipe(progenitorRepository.findById(gastoDTO.getProgenitorParticipeId())
                    .orElseThrow(() -> new RuntimeException("Progenitor partícipe no encontrado")));
        }
        if (gastoDTO.getParticionProgenitorCreador() != null) {
            existingGasto.setParticionProgenitorCreador(gastoDTO.getParticionProgenitorCreador());
        }
        if (gastoDTO.getParticionProgenitorParticipe() != null) {
            existingGasto.setParticionProgenitorParticipe(gastoDTO.getParticionProgenitorParticipe());
        }
        if (gastoDTO.getCategoriaId() != null) {
            existingGasto.setCategoria(categoriaRepository.findById(gastoDTO.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada")));
        }
        if (gastoDTO.getEstadoId() != null) {
            existingGasto.setEstado(estadoRepository.findById(gastoDTO.getEstadoId())
                    .orElseThrow(() -> new RuntimeException("Estado no encontrado")));
        }
        return GastoMapper.toDTO(gastoRepository.save(existingGasto));
    }

    @Override
    public GastoDTO findGasto(Long gastoId) {
        return GastoMapper.toDTO(gastoRepository.findById(gastoId)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado")));
    }

    @Override
    public void proponerNuevaParticion(Integer particionProgenitorCreador, Integer particionProgenitorParticipe, GastoDTO gasto) {

        Gasto gastoEntity = GastoMapper.toEntity(gasto);
        gastoEntity.setProgenitorCreador(progenitorRepository.findById(gasto.getProgenitorCreadorId())
                .orElseThrow(() -> new RuntimeException("Progenitor creador no encontrado")));
        gastoEntity.setProgenitorParticipe(progenitorRepository.findById(gasto.getProgenitorParticipeId())
                .orElseThrow(() -> new RuntimeException("Progenitor partícipe no encontrado")));
        gastoEntity.setCategoria(categoriaRepository.findById(gasto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada")));
        gastoEntity.setEstado(estadoRepository.findById(gasto.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado")));

        gastoEntity.setParticionProgenitorCreador(particionProgenitorCreador);
        gastoEntity.setParticionProgenitorParticipe(particionProgenitorParticipe);
        System.out.println(gastoEntity.getParticionProgenitorCreador());
        System.out.println(gastoEntity.getParticionProgenitorParticipe());

        gastoRepository.save(gastoEntity);
    }

    @Override
    public List<GastoDTO> findGastosByProgenitorId(Long progenitorId) {
        List<Gasto> gastos = gastoRepository.findAllByProgenitorCreadorIdOrProgenitorParticipeId(progenitorId, progenitorId);
        return gastos.stream().map(GastoMapper::toDTO).collect(Collectors.toList());
    }

}

