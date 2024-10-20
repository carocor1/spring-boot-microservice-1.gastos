package com.parplanner.spring_boot_microservice_1.gastos.estados.service;

import com.parplanner.spring_boot_microservice_1.gastos.estados.dto.EstadoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.estados.mapper.EstadoMapper;
import com.parplanner.spring_boot_microservice_1.gastos.estados.model.Estado;
import com.parplanner.spring_boot_microservice_1.gastos.estados.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public EstadoDTO saveEstado(EstadoDTO estadoDTO) {
        Estado estado = EstadoMapper.toEntity(estadoDTO);
        return EstadoMapper.toDTO(estadoRepository.save(estado));
    }

    @Override
    public void deleteEstado(Long estadoId) {
        estadoRepository.deleteById(estadoId);
    }

    @Override
    public List<EstadoDTO> findAllEstado() {
        return estadoRepository.findAll().stream()
                .map(EstadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoDTO updateEstado(Long estadoId, EstadoDTO estadoDTO) {
        Estado existingEstado = this.findEstado(estadoId);
        if (estadoDTO.getNombre() != null) {
            existingEstado.setNombre(estadoDTO.getNombre());
        }
        return EstadoMapper.toDTO(estadoRepository.save(existingEstado));
    }

    @Override
    public Estado findEstado(Long estadoId) {
        return estadoRepository.findById(estadoId)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    }
}
