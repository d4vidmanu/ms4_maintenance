-- Crear la tabla maintenance
CREATE TABLE IF NOT EXISTS mantenimiento (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             technician_id BIGINT,
                                             maintenance_date DATE,
                                             issue_reported VARCHAR(255),
    scooter_id BIGINT,
    status VARCHAR(50)
    );

-- Crear la tabla technician
CREATE TABLE IF NOT EXISTS technician (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(255),
    specialization VARCHAR(50)
    );

-- Insertar datos iniciales en technician
INSERT INTO technician (name, specialization) VALUES ('John Doe', 'ELECTRICAL');
INSERT INTO technician (name, specialization) VALUES ('Jane Smith', 'MECHANICAL');
INSERT INTO technician (name, specialization) VALUES ('Mike Johnson', 'SOFTWARE');
INSERT INTO technician (name, specialization) VALUES ('Anna White', 'BODYWORK');
INSERT INTO technician (name, specialization) VALUES ('Chris Brown', 'ELECTRICAL');

-- Insertar datos iniciales en mantenimiento
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (1, '2024-10-01', 'ELECTRICAL_FAILURE', 101, 'PENDING');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (2, '2024-10-02', 'MECHANICAL_FAILURE', 102, 'IN_PROGRESS');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (3, '2024-10-03', 'SOFTWARE_GLITCH', 103, 'PENDING');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (4, '2024-10-04', 'BODY_DAMAGE', 104, 'COMPLETED');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (5, '2024-10-05', 'ELECTRICAL_FAILURE', 105, 'IN_PROGRESS');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (1, '2024-10-06', 'MECHANICAL_FAILURE', 106, 'PENDING');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (2, '2024-10-07', 'ELECTRICAL_FAILURE', 107, 'COMPLETED');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (3, '2024-10-08', 'SOFTWARE_GLITCH', 108, 'CANCELLED');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (4, '2024-10-09', 'BODY_DAMAGE', 109, 'IN_PROGRESS');
INSERT INTO mantenimiento (technician_id, maintenance_date, issue_reported, scooter_id, status)
VALUES (5, '2024-10-10', 'MECHANICAL_FAILURE', 110, 'PENDING');
