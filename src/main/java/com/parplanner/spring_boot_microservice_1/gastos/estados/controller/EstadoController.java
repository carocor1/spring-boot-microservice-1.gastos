package com.parplanner.spring_boot_microservice_1.gastos.estados.controller;

import com.parplanner.spring_boot_microservice_1.gastos.estados.dto.EstadoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.estados.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<?> saveEstado(@RequestBody EstadoDTO estadoDTO) {
        return new ResponseEntity<>(estadoService.saveEstado(estadoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllEstado() {
        return new ResponseEntity<>(estadoService.findAllEstado(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> updateEstado(@PathVariable Long id, @RequestBody EstadoDTO estadoDTO) {
        return new ResponseEntity<>(estadoService.updateEstado(id, estadoDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEstado(@PathVariable Long id) {
        return new ResponseEntity<>(estadoService.findEstado(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstado(@PathVariable Long estadoId) {
        estadoService.deleteEstado(estadoId);
        return ResponseEntity.noContent().build();
    }
}
