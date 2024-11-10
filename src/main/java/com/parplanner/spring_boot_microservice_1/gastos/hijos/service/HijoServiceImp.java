package com.parplanner.spring_boot_microservice_1.gastos.hijos.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parplanner.spring_boot_microservice_1.gastos.hijos.dto.HijoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.hijos.mapper.HijoMapper;
import com.parplanner.spring_boot_microservice_1.gastos.hijos.model.Hijo;
import com.parplanner.spring_boot_microservice_1.gastos.hijos.repository.HijoRepository;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HijoServiceImp implements HijoService {

    @Autowired
    private HijoRepository hijoRepository;

    @Override
    public HijoDTO saveHijo(HijoDTO hijoDTO) {
        Hijo hijo = HijoMapper.toEntity(hijoDTO);
        return HijoMapper.toDTO(hijoRepository.save(hijo));
    }

    @Override
    public void deleteHijo(Long hijoId) {
        hijoRepository.deleteById(hijoId);
    }

    @Override
    public List<HijoDTO> findAllHijo() {
        return hijoRepository.findAll().stream()
                .map(HijoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HijoDTO updateHijo(Long hijoId, HijoDTO hijoDTO) {
        Hijo existingHijo = this.findHijo(hijoId);
        if (hijoDTO.getNombre() != null) {
            existingHijo.setNombre(hijoDTO.getNombre());
        }
        if (hijoDTO.getApellido() != null) {
            existingHijo.setApellido(hijoDTO.getApellido());
        }
        if (hijoDTO.getFechaDeNacimiento() != null) {
            existingHijo.setFechaDeNacimiento(LocalDate.parse(hijoDTO.getFechaDeNacimiento(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        }
        if (hijoDTO.getProvincia()!=null){
            existingHijo.setProvincia(hijoDTO.getProvincia());
        }
        if (hijoDTO.getCiudad() != null) {
            existingHijo.setCiudad(hijoDTO.getCiudad());
        }
        if (hijoDTO.getDocumento() != null) {
            existingHijo.setDocumento(hijoDTO.getDocumento());
        }

        return HijoMapper.toDTO(hijoRepository.save(existingHijo));
    }

    @Override
    public Hijo findHijo(Long hijoId) {
        return hijoRepository.findById(hijoId)
                .orElseThrow(() -> new RuntimeException("Hijo no encontrado"));
    }

}
