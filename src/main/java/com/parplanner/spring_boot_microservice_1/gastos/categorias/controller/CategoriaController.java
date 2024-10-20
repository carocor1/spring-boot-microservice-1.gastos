package com.parplanner.spring_boot_microservice_1.gastos.categorias.controller;

import com.parplanner.spring_boot_microservice_1.gastos.categorias.dto.CategoriaDTO;
import com.parplanner.spring_boot_microservice_1.gastos.categorias.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?> saveCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return new ResponseEntity<>(categoriaService.saveCategoria(categoriaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllCategoria() {
        return new ResponseEntity<>(categoriaService.findAllCategoria(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        return new ResponseEntity<>(categoriaService.updateCategoria(id, categoriaDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCategoria(@PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.findCategoria(id), HttpStatus.OK);
    }
}