-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS scooter_maintenance;

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS scooter_maintenance;
USE scooter_maintenance;

-- Eliminar las tablas si ya existen
DROP TABLE IF EXISTS MANTENIMIENTO;
DROP TABLE IF EXISTS TECNICO;

-- Crear la tabla TECNICO
CREATE TABLE IF NOT EXISTS TECNICO (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL
    );

-- Crear la tabla MANTENIMIENTO
CREATE TABLE IF NOT EXISTS MANTENIMIENTO (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             tecnicoId INT NULL,
                                             scooter_id INT NOT NULL,
                                             enter_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                             finish_date TIMESTAMP NULL,
                                             status ENUM('PENDING', 'IN_PROGRESS', 'COMPLETED') NOT NULL,
    FOREIGN KEY (tecnicoId) REFERENCES TECNICO(id)
    );

-- Crear un trigger que actualiza automáticamente finish_date cuando el status es COMPLETED
DELIMITER //
CREATE TRIGGER set_finish_date
    BEFORE UPDATE ON MANTENIMIENTO
    FOR EACH ROW
BEGIN
    IF NEW.status = 'COMPLETED' AND OLD.status <> 'COMPLETED' THEN
        SET NEW.finish_date = CURRENT_TIMESTAMP;
END IF;
END;
//
DELIMITER ;

-- Insertar datos en la tabla TECNICO
INSERT INTO TECNICO (name) VALUES
                               ('Juan Pérez'),
                               ('Ana Gómez'),
                               ('Carlos Ramírez');

-- Insertar datos en la tabla MANTENIMIENTO
-- Mantenimiento con tecnicoId = NULL, finish_date = NULL, status = PENDING
INSERT INTO MANTENIMIENTO (tecnicoId, scooter_id, enter_date, finish_date, status)
VALUES (NULL, 1, CURRENT_TIMESTAMP, NULL, 'PENDING');

-- Mantenimiento con tecnicoId = 2, finish_date = NULL, status = IN_PROGRESS
INSERT INTO MANTENIMIENTO (tecnicoId, scooter_id, enter_date, finish_date, status)
VALUES (2, 2, CURRENT_TIMESTAMP, NULL, 'IN_PROGRESS');

-- Mantenimiento con tecnicoId = 2, finish_date != NULL, status = COMPLETED
INSERT INTO MANTENIMIENTO (tecnicoId, scooter_id, enter_date, finish_date, status)
VALUES (2, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'COMPLETED');
