package com.api.maintenance.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "mantenimiento")
public class MaintenanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long technician_id;

    @Column
    private Date maintenance_date;

    @Enumerated(EnumType.STRING)
    @Column
    private IssueReported issue_reported;

    @Column
    private Long scooter_id;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;
}
