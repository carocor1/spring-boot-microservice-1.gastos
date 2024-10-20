package com.parplanner.spring_boot_microservice_1.gastos.progenitores.service;

import com.parplanner.spring_boot_microservice_1.gastos.progenitores.dto.ProgenitorDTO;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.mapper.ProgenitorMapper;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.model.Progenitor;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.repository.ProgenitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgenitorServiceImpl implements ProgenitorService {

    @Autowired
    private ProgenitorRepository progenitorRepository;

    @Override
    public ProgenitorDTO saveProgenitor(ProgenitorDTO progenitorDTO) {
        Progenitor progenitor = ProgenitorMapper.toEntity(progenitorDTO);
        return ProgenitorMapper.toDTO(progenitorRepository.save(progenitor));
    }

    @Override
    public void deleteProgenitor(Long progenitorId) {
        progenitorRepository.deleteById(progenitorId);
    }

    @Override
    public List<ProgenitorDTO> findAllProgenitor() {
        return progenitorRepository.findAll().stream()
                .map(ProgenitorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProgenitorDTO updateProgenitor(Long progenitorId, ProgenitorDTO progenitorDTO) {
        Progenitor existingProgenitor = this.findProgenitor(progenitorId);
        if (progenitorDTO.getNombre() != null) {
            existingProgenitor.setNombre(progenitorDTO.getNombre());
        }
        if (progenitorDTO.getApellido() != null) {
            existingProgenitor.setApellido(progenitorDTO.getApellido());
        }
        if (progenitorDTO.getFechaDeNacimiento() != null) {
            existingProgenitor.setFechaDeNacimiento(LocalDate.parse(progenitorDTO.getFechaDeNacimiento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        if (progenitorDTO.getCbu() != null) {
            existingProgenitor.setCbu(progenitorDTO.getCbu());
        }
        if (progenitorDTO.getNroTelefono() != null) {
            existingProgenitor.setNroTelefono(progenitorDTO.getNroTelefono());
        }
        return ProgenitorMapper.toDTO(progenitorRepository.save(existingProgenitor));
    }

    @Override
    public Progenitor findProgenitor(Long progenitorId) {
        return progenitorRepository.findById(progenitorId)
                .orElseThrow(() -> new RuntimeException("Progenitor no encontrado"));
    }

}
