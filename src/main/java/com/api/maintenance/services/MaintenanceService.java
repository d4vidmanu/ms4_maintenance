package com.api.maintenance.services;

import com.api.maintenance.models.MaintenanceModel;
import com.api.maintenance.repositories.IMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MaintenanceService {
    @Autowired
    IMaintenanceRepository maintenanceRepository;

    // Obtener todos los mantenimientos
    public ArrayList<MaintenanceModel> getMaintenances(){
        return (ArrayList<MaintenanceModel>) maintenanceRepository.findAll();
    }

    // Guardar un mantenimiento nuevo
    public MaintenanceModel saveMaintenance(MaintenanceModel maintenance){
        return maintenanceRepository.save(maintenance);
    }

    // Obtener mantenimiento por ID
    public Optional<MaintenanceModel> getMaintenanceById(Long id){
        return maintenanceRepository.findById(id);
    }

    // Actualizar mantenimiento por ID
    public MaintenanceModel updateMaintenanceById(Long id, MaintenanceModel maintenance){
        Optional<MaintenanceModel> existingMaintenance = maintenanceRepository.findById(id);

        if (existingMaintenance.isPresent()) {
            MaintenanceModel this_maintenance = existingMaintenance.get();

            // Actualizar los campos con los nuevos valores del objeto "maintenance"
            this_maintenance.setTechnician_id(maintenance.getTechnician_id());
            this_maintenance.setMaintenance_date(maintenance.getMaintenance_date());
            this_maintenance.setIssue_reported(maintenance.getIssue_reported());
            this_maintenance.setScooter_id(maintenance.getScooter_id());
            this_maintenance.setStatus(maintenance.getStatus());

            // Guardar el objeto actualizado en la base de datos
            return maintenanceRepository.save(this_maintenance);
        } else {
            return null; // Si no encuentra el registro, retornar null o lanzar una excepción
        }
    }

    // Eliminar mantenimiento por ID
    public boolean deleteMaintenanceById(Long id){
        try {
            maintenanceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
