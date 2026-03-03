# Conversor de Monedas - Challenge ONE Java

### 📋 Descripción
Este proyecto es un conversor de divisas interactivo desarrollado en Java como parte del programa **Oracle Next Education (ONE)**. La aplicación consume datos en tiempo real de una API externa para realizar conversiones precisas entre distintas monedas globales.

### 🚀 Características
* **Conexión en Tiempo Real:** Utiliza la [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas actualizadas.
* **Interfaz de Consola:** Menú interactivo y robusto desarrollado con la clase `Scanner`.
* **Historial de Consultas:** Registro de las operaciones realizadas durante la sesión para un mejor seguimiento.
* **Manejo de Errores:** Implementación de bloques `try-catch` y `try-with-resources` para garantizar la estabilidad del sistema.
* **Formato Profesional:** Resultados numéricos con `DecimalFormat` (2 decimales) y registros de tiempo con `LocalDateTime`.

### 🛠️ Tecnologías Utilizadas
* **Java SDK 17+**
* **Maven** (Gestor de dependencias)
* **Gson 2.11.0** (Para el procesamiento de datos JSON)
* **HttpClient** (Para peticiones HTTP nativas)

### 📂 Estructura del Proyecto
* `Principal.java`: Clase principal que gestiona el menú y la interacción con el usuario.
* `ConsultaMoneda.java`: Motor que realiza las peticiones a la API y el parseo de datos.
* `Moneda.java`: Record que actúa como modelo de datos inmutable.

### ⚙️ Configuración y Uso
1. Clonar este repositorio.
2. Registrarse en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una API Key.
3. Colocar la clave en el campo `apiKey` dentro de la clase `ConsultaMoneda.java`.
4. Ejecutar la clase `Principal.java` desde tu IDE preferido.

---
*Desarrollado por Juan Francisco Rocco - 2026*