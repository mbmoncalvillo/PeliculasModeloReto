
## 🚀 Proyecto: PeliculasModeloReto

## 📝 Descripción

Ejemplo de acceso a una BD para mostrar resultados en JFrames de Swing, usando una interface por ventana para acceder a la BD

---

## 🧰 Tecnologías utilizadas

💻 Java 8 / JavaFX
🗄️ MySQL
🔌 JDBC (conector MySQL)
🛠️ Herramientas: Eclipse

---

## 📚 Dependencias

Este proyecto utiliza las siguientes librerías externas:

* 🔌 **Conector JDBC MySQL** (ej: `mysql-connector-java-x.x.x.jar`)
  
---

## 🗄️ Base de datos

El proyecto incluye el script de base de datos:

📄 `bd.sql`

### ▶️ Cómo usarlo

1. Crear una base de datos en MySQL
2. Importar el fichero `bd.sql`

   * Desde consola:

   ```bash id="n3k2d9"
   mysql -u usuario -p nombre_bd < bd.sql
   ```

   * O usando una herramienta gráfica como MySQL Workbench

---

## 📦 Instalación

### 📥 Clonar el repositorio

```bash id="v8q1xm"
git clone https://github.com/usuario/repositorio.git
```

### 📁 Importar el proyecto

* Abrir el proyecto en tu IDE (NetBeans / IntelliJ / VS Code)

### ➕ Añadir dependencias manualmente

1. Descargar:

   * Conector JDBC de MySQL
   * Librerías de Mockito
2. Añadir los `.jar` al proyecto (ver sección anterior)

---

## ▶️ Ejecución

1. Configurar la conexión a la base de datos en el proyecto
2. Ejecutar la aplicación desde el `main`

---

## 🧪 Tests

El proyecto incluye pruebas unitarias usando **Mockito**.

Para ejecutarlas:

* Desde el IDE → Ejecutar tests
* Asegúrate de que los JAR de Mockito están correctamente añadidos

---

Si quieres, puedo adaptarlo a un formato más “guiado para alumnos” (tipo checklist de entrega), que suele funcionar muy bien en clase 👍
