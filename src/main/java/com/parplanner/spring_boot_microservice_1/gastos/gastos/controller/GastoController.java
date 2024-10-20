package com.parplanner.spring_boot_microservice_1.gastos.gastos.controller;

import com.parplanner.spring_boot_microservice_1.gastos.gastos.dto.GastoDTO;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.model.Gasto;
import com.parplanner.spring_boot_microservice_1.gastos.gastos.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gasto")
@CrossOrigin(origins = "http://192.168.0.155:8081")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    // Crear un nuevo gasto
    @PostMapping
    public ResponseEntity<GastoDTO> saveGasto(@RequestBody GastoDTO gastoDTO) {
        return new ResponseEntity<>(gastoService.saveGasto(gastoDTO), HttpStatus.CREATED);
    }

    // Obtener todos los gastos
    @GetMapping
    public ResponseEntity<?> findAllGasto() {
        return new ResponseEntity<>(gastoService.findAllGasto(), HttpStatus.OK);
    }

    // Actualizar un gasto existente
    @PutMapping("/{id}")
    public ResponseEntity<GastoDTO> updateGasto(@PathVariable Long id, @RequestBody GastoDTO gastoDTO) {
        return new ResponseEntity<>(gastoService.updateGasto(id, gastoDTO), HttpStatus.OK);
    }

    // Obtener un gasto específico
    @GetMapping("/{id}")
    public ResponseEntity<GastoDTO> findGasto(@PathVariable Long id) {
        return new ResponseEntity<>(gastoService.findGasto(id), HttpStatus.OK);
    }

    // Eliminar un gasto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable Long gastoId) {
        gastoService.deleteGasto(gastoId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/proponerParticion")
    public ResponseEntity<Void> proponerNuevaParticion(@PathVariable Long id, @RequestBody GastoDTO gastoDTO) {
        GastoDTO gastoDTOEncontrado = gastoService.findGasto(id);
        System.out.println("GastoDTO encontrado: "+ gastoDTOEncontrado);
        gastoService.proponerNuevaParticion(gastoDTO.getParticionProgenitorCreador(), gastoDTO.getParticionProgenitorParticipe(), gastoDTOEncontrado);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/progenitor/{id}")
    public ResponseEntity<List<GastoDTO>> findGastosByProgenitorId(@PathVariable Long id) {
        return new ResponseEntity<>(gastoService.findGastosByProgenitorId(id), HttpStatus.OK);

    }
}

