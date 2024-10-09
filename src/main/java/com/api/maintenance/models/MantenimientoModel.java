package com.api.maintenance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mantenimiento")
public class MantenimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relación ManyToOne con TecnicoModel
    @ManyToOne
    @JoinColumn(name = "tecnicoid", referencedColumnName = "id") // Cambiar "tecnico_id" a "tecnicoId"
    private TecnicoModel tecnico;

    @Column(nullable = false)
    private int scooter_id;

    @Column(nullable = false)
    private Timestamp enter_date;

    @Column(nullable = true)
    private Timestamp finish_date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}
