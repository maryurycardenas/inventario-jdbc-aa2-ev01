# Módulo de Inventario - GA7-220501096-AA2-EV01

Codificación del módulo de productos con conexión a MySQL por JDBC (Java 17, Maven).

**Aprendiz:** Maryury Cardenas Ortega
**Ficha:** 3336248
**Programa:** Análisis y desarrollo de software

## Funcionalidades
- Inserción de productos.
- Consulta de todos los productos y consulta por ID.
- Actualización de productos.
- Eliminación de productos.

## Estructura del proyecto
```
inventario-jdbc/
├── database/script.sql        Script de la base de datos
├── docs/                      Diseño, estándar de codificación y capturas
├── src/main/java/com/proyecto/inventario/
│   ├── conexion/ConexionBD.java
│   ├── modelo/Producto.java
│   ├── dao/ProductoDAO.java
│   └── principal/Main.java
└── pom.xml
```

## Ejecución
1. Ejecutar `database/script.sql` en MySQL.
2. Configurar usuario y contraseña en `ConexionBD.java`.
3. Ejecutar la clase `Main` desde Visual Studio Code.

## Estándares de codificación
Ver `docs/estandar_codificacion.md`.

| Elemento | Convención | Ejemplo |
|---|---|---|
| Paquetes | minúsculas, sin guiones | `com.proyecto.inventario.dao` |
| Clases | PascalCase, sustantivos | `ProductoDAO`, `ConexionBD` |
| Métodos | camelCase, empiezan con verbo | `consultarPorId`, `insertar` |
| Variables y atributos | camelCase, nombres descriptivos | `idProducto`, `conexion` |
| Constantes | MAYÚSCULAS con guion bajo | `URL`, `CONTRASENA` |
| Tablas y columnas (BD) | minúsculas con guion bajo | `id_producto` |

## Artefactos del ciclo de software
Ver `docs/diseno_del_modulo.md` (historias de usuario, casos de uso, diagrama de clases,
prototipo y plan de trabajo) y las capturas de pruebas en `docs/capturas/`.
