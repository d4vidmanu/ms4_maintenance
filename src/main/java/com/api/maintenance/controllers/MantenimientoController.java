package com.api.maintenance.controllers;
import com.api.maintenance.dto.MantenimientoUpdateRequest;
import com.api.maintenance.models.MantenimientoModel;
import com.api.maintenance.services.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping
    public List<MantenimientoModel> getAllMantenimientos() {
        return mantenimientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoModel> getMantenimientoById(@PathVariable int id) {
        Optional<MantenimientoModel> mantenimiento = mantenimientoService.findById(id);
        return mantenimiento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MantenimientoModel createMantenimiento(@RequestBody MantenimientoModel mantenimiento) {
        return mantenimientoService.save(mantenimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoModel> updateMantenimiento(@PathVariable int id, @RequestBody MantenimientoModel mantenimientoDetails) {
        Optional<MantenimientoModel> updatedMantenimiento = mantenimientoService.update(id, mantenimientoDetails);
        return updatedMantenimiento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMantenimiento(@PathVariable int id) {
        mantenimientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pending")
    public List<MantenimientoModel> getPendingMantenimientos() {
        return mantenimientoService.findByStatus(MantenimientoModel.Status.PENDING);
    }

    @GetMapping("/tecnico/{id_tecnico}")
    public List<MantenimientoModel> getMantenimientosByTecnicoId(@PathVariable("id_tecnico") Integer idTecnico) {
        return mantenimientoService.findByTecnicoId(idTecnico);
    }

    @PatchMapping("/{id}/status-tecnico")
    public ResponseEntity<MantenimientoModel> updateMantenimientoStatusAndTecnico(
            @PathVariable int id,
            @RequestBody MantenimientoUpdateRequest request) {

        Optional<MantenimientoModel> updatedMantenimiento = mantenimientoService.updateStatusAndTecnico(id, request.getStatus(), request.getTecnicoId());

        return updatedMantenimiento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}