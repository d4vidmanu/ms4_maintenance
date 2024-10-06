package com.api.maintenance.services;

import com.api.maintenance.models.TechnicianModel;
import com.api.maintenance.repositories.ITechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TechnicianService {
    @Autowired
    ITechnicianRepository technicianRepository;

    // Obtener todos los técnicos
    public ArrayList<TechnicianModel> getTechnicians() {
        return (ArrayList<TechnicianModel>) technicianRepository.findAll();
    }

    // Guardar nuevo técnico
    public TechnicianModel saveTechnician(TechnicianModel technician) {
        return technicianRepository.save(technician);
    }

    // Obtener técnico por ID
    public Optional<TechnicianModel> getTechnicianById(Long id) {
        return technicianRepository.findById(id);
    }

    // Actualizar técnico por ID
    public TechnicianModel updateTechnicianById(Long id, TechnicianModel technician) {
        Optional<TechnicianModel> existingTechnician = technicianRepository.findById(id);

        if (existingTechnician.isPresent()) {
            TechnicianModel this_technician = existingTechnician.get();

            // Actualizar los campos con los nuevos valores
            this_technician.setName(technician.getName());
            this_technician.setSpecialization(technician.getSpecialization());

            // Guardar el técnico actualizado en la base de datos
            return technicianRepository.save(this_technician);
        } else {
            return null; // Si no encuentra el registro, retornar null o lanzar una excepción
        }
    }

    // Eliminar técnico por ID
    public boolean deleteTechnicianById(Long id) {
        try {
            technicianRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
