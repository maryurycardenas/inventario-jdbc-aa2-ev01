package com.proyecto.inventario.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de crear la conexión JDBC con la base de datos MySQL.
 */
public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/inventario_db"
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Bogota";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "TU_CONTRASENA";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
