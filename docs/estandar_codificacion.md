# Estándar de codificación

Este documento define las reglas que sigue el código del proyecto.

## 1. Nombramiento de paquetes
- Todo en minúsculas, sin guiones ni guiones bajos.
- Estructura: `com.proyecto.inventario.<capa>`.
- Ejemplos: `conexion`, `modelo`, `dao`, `principal`.

## 2. Nombramiento de clases
- PascalCase (cada palabra inicia en mayúscula).
- Nombres en singular y sustantivos.
- Las clases de acceso a datos terminan en `DAO`.
- Ejemplos: `Producto`, `ProductoDAO`, `ConexionBD`, `Main`.

## 3. Nombramiento de métodos
- camelCase y deben empezar con un verbo.
- Ejemplos: `insertar`, `consultarTodos`, `consultarPorId`, `actualizar`, `eliminar`, `obtenerConexion`.
- Los métodos de lectura y escritura de atributos usan `get` y `set`.

## 4. Nombramiento de variables
- camelCase y nombres descriptivos, sin abreviaturas confusas.
- Ejemplos: `idProducto`, `nombre`, `sentencia`, `resultado`, `conexion`.
- Las constantes van en MAYÚSCULAS con guion bajo: `URL`, `USUARIO`, `CONTRASENA`.

## 5. Formato
- Una clase pública por archivo, con el mismo nombre del archivo.
- Sangría de 4 espacios y llaves de apertura en la misma línea.
- Comentarios Javadoc (`/** ... */`) en cada clase.
- Se usan `PreparedStatement` con parámetros (`?`) en todas las consultas SQL.
- Los recursos JDBC se cierran con `try-with-resources`.

## 6. Base de datos
- Tablas y columnas en minúsculas con guion bajo (`id_producto`).
- Clave primaria autoincremental llamada `id_<tabla>`.

## 7. Versionamiento
- Repositorio Git alojado en GitHub, rama principal `main`.
- Mensajes de commit con prefijo: `feat:` (funcionalidad), `docs:` (documentación), `chore:` (configuración).
