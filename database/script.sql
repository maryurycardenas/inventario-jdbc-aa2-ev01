CREATE DATABASE IF NOT EXISTS inventario_db
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE inventario_db;

CREATE TABLE IF NOT EXISTS producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio      DECIMAL(10,2) NOT NULL,
    stock       INT NOT NULL DEFAULT 0
);

INSERT INTO producto (nombre, descripcion, precio, stock) VALUES
('Teclado', 'Teclado USB en español', 45000.00, 20),
('Mouse', 'Mouse óptico inalámbrico', 30000.00, 35);
