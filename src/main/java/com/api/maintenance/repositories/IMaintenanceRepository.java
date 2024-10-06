package com.api.maintenance.repositories;

import com.api.maintenance.models.MaintenanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaintenanceRepository extends JpaRepository<MaintenanceModel, Long> {
}
