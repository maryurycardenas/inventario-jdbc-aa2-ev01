# Pruebas del CRUD - GA7-220501096-AA2-EV01

**Aprendiz:** Maryury Cardenas Ortega
**Fecha:** 15/11/2026

Pruebas hechas ejecutando la clase `Main` en Visual Studio Code, con conexión JDBC a la base de datos `inventario_db` (MySQL en XAMPP).

## 1. Consultar todos los productos (opción 2)
Estado inicial de la tabla `producto`:
```
ID: 1 | Teclado | Teclado USB en español | $45000.0 | Stock: 20
ID: 2 | Mouse | Mouse óptico inalámbrico | $30000.0 | Stock: 35
ID: 3 | Teclado | Teclado USB en español | $45000.0 | Stock: 20
ID: 4 | Mouse | Mouse óptico inalámbrico | $30000.0 | Stock: 35
```

## 2. Insertar producto (opción 1)
Datos ingresados: nombre `monitor`, precio `350000`, stock `10`.
Resultado: `Producto insertado correctamente.`
```
ID: 5 | monitor | maryury  | $350000.0 | Stock: 10
```
Además, el programa rechazó un texto escrito en el campo precio y pidió un número válido (`Ingrese un número válido.`).

## 3. Actualizar producto (opción 4)
Producto con ID 5: nuevo nombre `Monitor LED`, nueva descripción `Monitor LED 24 pulgadas`, precio `350000`, stock `15`.
Resultado: `Producto actualizado correctamente.`

## 4. Consultar producto por ID (opción 3)
Consulta del ID 5:
```
ID: 5 | Monitor LED | Monitor LED 24 pulgadas | $350000.0 | Stock: 15
```

## 5. Eliminar producto (opción 5)
Se eliminaron los productos con ID 3 y 4.
Resultado en ambos casos: `Producto eliminado correctamente.`

## 6. Estado final de la tabla
```
ID: 1 | Teclado | Teclado USB en español | $45000.0 | Stock: 20
ID: 2 | Mouse | Mouse óptico inalámbrico | $30000.0 | Stock: 35
ID: 5 | Monitor LED | Monitor LED 24 pulgadas | $350000.0 | Stock: 15
```
