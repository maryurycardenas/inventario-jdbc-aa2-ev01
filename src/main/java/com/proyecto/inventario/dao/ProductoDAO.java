package com.proyecto.inventario.dao;

import com.proyecto.inventario.conexion.ConexionBD;
import com.proyecto.inventario.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Acceso a datos de la tabla producto: insertar, consultar, actualizar y eliminar.
 */
public class ProductoDAO {

    public boolean insertar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
            return false;
        }
    }

    public List<Producto> consultarTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, descripcion, precio, stock FROM producto";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                productos.add(mapearProducto(resultado));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los productos: " + e.getMessage());
        }
        return productos;
    }

    public Producto consultarPorId(int idProducto) {
        String sql = "SELECT id_producto, nombre, descripcion, precio, stock "
                + "FROM producto WHERE id_producto = ?";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, idProducto);
            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapearProducto(resultado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el producto: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, stock = ? "
                + "WHERE id_producto = ?";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());
            sentencia.setInt(5, producto.getIdProducto());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idProducto) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, idProducto);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }

    private Producto mapearProducto(ResultSet resultado) throws SQLException {
        return new Producto(
                resultado.getInt("id_producto"),
                resultado.getString("nombre"),
                resultado.getString("descripcion"),
                resultado.getDouble("precio"),
                resultado.getInt("stock"));
    }
}
