package com.parplanner.spring_boot_microservice_1.gastos.hijos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parplanner.spring_boot_microservice_1.gastos.hijos.dto.HijoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.hijos.service.HijoService;


@RestController
public class HijoController {

    @Autowired
     
    private HijoService hijoService; 


    @PostMapping
    public ResponseEntity<?> saveHijo(@RequestBody HijoDTO hijoDTO){
        return new ResponseEntity<>(hijoService.saveHijo(hijoDTO), HttpStatus.CREATED);
    }
   

    //OBTENER TODOS
    @GetMapping
    public ResponseEntity<?> findAllHijo() {
        return new ResponseEntity<>(hijoService.findAllHijo(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HijoDTO> updateHijo(@PathVariable Long id, @RequestBody HijoDTO hijoDTO) {
        return new ResponseEntity<>(hijoService.updateHijo(id, hijoDTO), HttpStatus.OK);
    }

    //OBTENER UNO
    @GetMapping("/{id}")
    public ResponseEntity<?> findHijo(@PathVariable Long id) {
        return new ResponseEntity<>(hijoService.findHijo(id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHijo(@PathVariable Long hijoId) {
        hijoService.deleteHijo(hijoId);
        return ResponseEntity.noContent().build();
    }
    
}
