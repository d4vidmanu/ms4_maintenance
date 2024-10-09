package com.api.maintenance.services;

import com.api.maintenance.models.TecnicoModel;
import com.api.maintenance.repositories.TecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<TecnicoModel> findAll() {
        return tecnicoRepository.findAll();
    }

    public Optional<TecnicoModel> findById(int id) {
        return tecnicoRepository.findById(id);
    }

    public TecnicoModel save(TecnicoModel tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public void deleteById(int id) {
        tecnicoRepository.deleteById(id);
    }

    // Método update añadido
    public Optional<TecnicoModel> updateTecnico(int id, TecnicoModel tecnicoDetails) {
        Optional<TecnicoModel> tecnico = tecnicoRepository.findById(id);
        if (tecnico.isPresent()) {
            TecnicoModel updatedTecnico = tecnico.get();
            updatedTecnico.setName(tecnicoDetails.getName());
            return Optional.of(tecnicoRepository.save(updatedTecnico));
        } else {
            return Optional.empty();
        }
    }
}
