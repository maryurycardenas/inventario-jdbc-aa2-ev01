package com.proyecto.inventario.principal;

import com.proyecto.inventario.dao.ProductoDAO;
import com.proyecto.inventario.modelo.Producto;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal: menú de consola para gestionar los productos.
 */
public class Main {

    private static final ProductoDAO productoDAO = new ProductoDAO();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> insertarProducto();
                case 2 -> consultarProductos();
                case 3 -> consultarProductoPorId();
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== INVENTARIO DE PRODUCTOS =====");
        System.out.println("1. Insertar producto");
        System.out.println("2. Consultar todos los productos");
        System.out.println("3. Consultar producto por ID");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Salir");
    }

    private static void insertarProducto() {
        Producto producto = new Producto();
        System.out.print("Nombre: ");
        producto.setNombre(teclado.nextLine());
        System.out.print("Descripción: ");
        producto.setDescripcion(teclado.nextLine());
        producto.setPrecio(leerDecimal("Precio: "));
        producto.setStock(leerEntero("Stock: "));

        if (productoDAO.insertar(producto)) {
            System.out.println("Producto insertado correctamente.");
        }
    }

    private static void consultarProductos() {
        List<Producto> productos = productoDAO.consultarTodos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            productos.forEach(System.out::println);
        }
    }

    private static void consultarProductoPorId() {
        int id = leerEntero("ID del producto: ");
        Producto producto = productoDAO.consultarPorId(id);
        if (producto == null) {
            System.out.println("No se encontró un producto con ese ID.");
        } else {
            System.out.println(producto);
        }
    }

    private static void actualizarProducto() {
        int id = leerEntero("ID del producto a actualizar: ");
        Producto producto = productoDAO.consultarPorId(id);
        if (producto == null) {
            System.out.println("No se encontró un producto con ese ID.");
            return;
        }
        System.out.print("Nuevo nombre: ");
        producto.setNombre(teclado.nextLine());
        System.out.print("Nueva descripción: ");
        producto.setDescripcion(teclado.nextLine());
        producto.setPrecio(leerDecimal("Nuevo precio: "));
        producto.setStock(leerEntero("Nuevo stock: "));

        if (productoDAO.actualizar(producto)) {
            System.out.println("Producto actualizado correctamente.");
        }
    }

    private static void eliminarProducto() {
        int id = leerEntero("ID del producto a eliminar: ");
        if (productoDAO.eliminar(id)) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar (verifique el ID).");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}
