package com.api.maintenance.controllers;

import com.api.maintenance.models.TechnicianModel;
import com.api.maintenance.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    @Autowired
    TechnicianService technicianService;

    // Obtener todos los técnicos
    @GetMapping
    public ArrayList<TechnicianModel> getTechnicians() {
        return technicianService.getTechnicians();
    }

    // Guardar nuevo técnico
    @PostMapping
    public TechnicianModel saveTechnician(@RequestBody TechnicianModel technician) {
        return technicianService.saveTechnician(technician);
    }

    // Obtener técnico por ID
    @GetMapping(path = "/{id}")
    public Optional<TechnicianModel> getTechnicianById(@PathVariable Long id) {
        return technicianService.getTechnicianById(id);
    }

    // Actualizar técnico por ID
    @PutMapping(path = "/{id}")
    public TechnicianModel updateTechnicianById(@PathVariable Long id, @RequestBody TechnicianModel technician) {
        return technicianService.updateTechnicianById(id, technician);
    }

    // Eliminar técnico por ID
    @DeleteMapping(path = "/{id}")
    public String deleteTechnicianById(@PathVariable Long id) {
        boolean ok = technicianService.deleteTechnicianById(id);
        if (ok) {
            return "El técnico con id " + id + " fue eliminado correctamente.";
        } else {
            return "No se pudo eliminar el técnico con id " + id;
        }
    }
}
