package com.api.maintenance.repositories;

import com.api.maintenance.models.MantenimientoModel;
import com.api.maintenance.models.TecnicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<MantenimientoModel, Integer> {
    List<MantenimientoModel> findByStatus(MantenimientoModel.Status status);

    // Cambia a findByTecnicoId
    List<MantenimientoModel> findByTecnico(TecnicoModel tecnico);
}