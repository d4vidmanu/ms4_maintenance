package com.api.maintenance.repositories;

import com.api.maintenance.models.TechnicianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITechnicianRepository extends JpaRepository<TechnicianModel, Long> {
}
