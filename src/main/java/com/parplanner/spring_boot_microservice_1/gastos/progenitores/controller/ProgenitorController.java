package com.parplanner.spring_boot_microservice_1.gastos.progenitores.controller;

import com.parplanner.spring_boot_microservice_1.gastos.progenitores.dto.ProgenitorDTO;
import com.parplanner.spring_boot_microservice_1.gastos.progenitores.service.ProgenitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/progenitor")
public class ProgenitorController {

    @Autowired
    private ProgenitorService progenitorService;

    //CREAR
    @PostMapping
    public ResponseEntity<?> saveProgenitor(@RequestBody ProgenitorDTO progenitorDTO) {
        return new ResponseEntity<>(progenitorService.saveProgenitor(progenitorDTO), HttpStatus.CREATED);
    }

    //OBTENER TODOS
    @GetMapping
    public ResponseEntity<?> findAllProgenitor() {
        return new ResponseEntity<>(progenitorService.findAllProgenitor(), HttpStatus.OK);
    }

    //ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ProgenitorDTO> updateProgenitor(@PathVariable Long id, @RequestBody ProgenitorDTO progenitorDTO) {
        return new ResponseEntity<>(progenitorService.updateProgenitor(id, progenitorDTO), HttpStatus.OK);
    }

    //OBTENER UNO
    @GetMapping("/{id}")
    public ResponseEntity<?> findProgenitor(@PathVariable Long id) {
        return new ResponseEntity<>(progenitorService.findProgenitor(id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProgenitor(@PathVariable Long progenitorId) {
        progenitorService.deleteProgenitor(progenitorId);
        return ResponseEntity.noContent().build();
    }
}

