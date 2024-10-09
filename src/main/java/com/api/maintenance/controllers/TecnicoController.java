package com.api.maintenance.controllers;

import com.api.maintenance.models.TecnicoModel;
import com.api.maintenance.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public List<TecnicoModel> getAllTecnicos() {
        return tecnicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoModel> getTecnicoById(@PathVariable int id) {
        Optional<TecnicoModel> tecnico = tecnicoService.findById(id);
        return tecnico.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TecnicoModel createTecnico(@RequestBody TecnicoModel tecnico) {
        return tecnicoService.save(tecnico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoModel> updateTecnico(@PathVariable int id, @RequestBody TecnicoModel tecnicoDetails) {
        Optional<TecnicoModel> updatedTecnico = tecnicoService.updateTecnico(id, tecnicoDetails);
        return updatedTecnico.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTecnico(@PathVariable int id) {
        tecnicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
