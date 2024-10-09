package com.api.maintenance.repositories;

import com.api.maintenance.models.TecnicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<TecnicoModel, Integer> {
}