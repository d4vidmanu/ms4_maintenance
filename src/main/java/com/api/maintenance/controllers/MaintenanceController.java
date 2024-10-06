package com.api.maintenance.controllers;

import com.api.maintenance.models.MaintenanceModel;
import com.api.maintenance.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    // Obtener todos los mantenimientos
    @GetMapping
    public ArrayList<MaintenanceModel> getMaintenance() {
        return this.maintenanceService.getMaintenances();
    }

    // Guardar nuevo mantenimiento
    @PostMapping
    public MaintenanceModel saveMaintenance(@RequestBody MaintenanceModel maintenance) {
        return this.maintenanceService.saveMaintenance(maintenance);
    }

    // Obtener mantenimiento por ID
    @GetMapping(path = "/{id}")
    public Optional<MaintenanceModel> getMaintenanceById(@PathVariable Long id) {
        return this.maintenanceService.getMaintenanceById(id);
    }

    // Actualizar mantenimiento por ID
    @PutMapping(path = "/{id}")
    public MaintenanceModel updateMaintenanceById(@PathVariable Long id, @RequestBody MaintenanceModel maintenance) {
        return this.maintenanceService.updateMaintenanceById(id, maintenance);
    }

    // Eliminar mantenimiento por ID
    @DeleteMapping(path = "/{id}")
    public String deleteMaintenanceById(@PathVariable Long id) {
        boolean ok = this.maintenanceService.deleteMaintenanceById(id);
        if (ok) {
            return "El mantenimiento con id " + id + " fue eliminado correctamente.";
        } else {
            return "No se pudo eliminar el mantenimiento con id " + id;
        }
    }
}
