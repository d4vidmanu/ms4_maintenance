package com.api.maintenance.services;

import com.api.maintenance.models.MantenimientoModel;
import com.api.maintenance.models.TecnicoModel;
import com.api.maintenance.repositories.MantenimientoRepository;
import com.api.maintenance.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;  // Añadido para obtener TecnicoModel

    public List<MantenimientoModel> findAll() {
        return mantenimientoRepository.findAll();
    }

    public Optional<MantenimientoModel> findById(int id) {
        return mantenimientoRepository.findById(id);
    }

    public MantenimientoModel save(MantenimientoModel mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    public void deleteById(int id) {
        mantenimientoRepository.deleteById(id);
    }

    public Optional<MantenimientoModel> update(int id, MantenimientoModel mantenimientoDetails) {
        Optional<MantenimientoModel> mantenimiento = mantenimientoRepository.findById(id);
        if (mantenimiento.isPresent()) {
            MantenimientoModel updatedMantenimiento = mantenimiento.get();

            // Obtener el TecnicoModel por su id (si no es nulo)
            if (mantenimientoDetails.getTecnico() != null) {
                Optional<TecnicoModel> tecnico = tecnicoRepository.findById(mantenimientoDetails.getTecnico().getId());
                tecnico.ifPresent(updatedMantenimiento::setTecnico);  // Asignar el técnico si existe
            }

            updatedMantenimiento.setFinish_date(mantenimientoDetails.getFinish_date());
            updatedMantenimiento.setStatus(mantenimientoDetails.getStatus());
            return Optional.of(mantenimientoRepository.save(updatedMantenimiento));
        } else {
            return Optional.empty();
        }
    }

    public List<MantenimientoModel> findByStatus(MantenimientoModel.Status status) {
        return mantenimientoRepository.findByStatus(status);
    }

    public List<MantenimientoModel> findByTecnicoId(Integer tecnicoId) {
        Optional<TecnicoModel> tecnico = tecnicoRepository.findById(tecnicoId);
        return tecnico.map(mantenimientoRepository::findByTecnico).orElse(null);
    }

    public Optional<MantenimientoModel> updateStatusAndTecnico(int id, MantenimientoModel.Status newStatus, Integer newTecnicoId) {
        Optional<MantenimientoModel> mantenimiento = mantenimientoRepository.findById(id);
        if (mantenimiento.isPresent()) {
            MantenimientoModel updatedMantenimiento = mantenimiento.get();
            updatedMantenimiento.setStatus(newStatus);

            // Si el tecnicoId es válido (no es null), actualiza el técnico.
            if (newTecnicoId != null) {
                Optional<TecnicoModel> tecnico = tecnicoRepository.findById(newTecnicoId);
                tecnico.ifPresent(updatedMantenimiento::setTecnico);
            }

            return Optional.of(mantenimientoRepository.save(updatedMantenimiento));
        } else {
            return Optional.empty();
        }
    }

}
