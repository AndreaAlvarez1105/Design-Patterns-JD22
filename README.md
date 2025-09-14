# Implementación de Patrones de Diseño Creacionales, Estructurales y de Comportamiento

**Java Developer 22 - Kodigo**

**Autores:**
- **Hugo Jovel**
- **Andrea Álvarez**

## ¿Por qué se implementaron los patrones de diseño?

**1. Patrones Creacionales**
- *Singleton para el sistema de reservas:* Se utilizó para tener un punto central que mantenga el estado global de todas las reservas. Asi evitamos la duplicación de reservas o falta de información en la base de datos.
- *Factory Method para los servicios de reservas:* Se implemento debido a que el sistema cuenta con diversos servicios y facilita agregar nuevos tipos de servicios.
- *Builder para reservas más complejas:* Al una reserva tner muchos campos de información o detalles, este patrón nos permite construir y validar el objeto paso a paso, validando si es correcto antes de crear el objeto final.


**2. Patrones Estructurales**
- *Adapter para servicios no compatibles:* Este patrón nos permite tener una interfaz uniforme para todos los servicios y nos permite integrar el sistema con sujetos externos. 
- *Facade para una interfaz simplificada:* Con este patrón se simplifica la complejidad del sistema para el usuario o el cliente, nos permite centralizar acciones u operaciones, facilitando el mantenimiento del sistema. 
- *Decorator para ervicios adicionales:* Este patrón es necesario cuando los usuarios quieren agregar servicios opcionales afectando el precio total, es decir que nos permite la modificación de forma dinámica sin crear subclases innecesarias.

**3.Patrones de Comportamiento**
- *Strategy para los métodos de pago:* Al nuestro sistema requerir múltiples opciones para realizar el pago, este patrón nos lo facilita al no tener código condicional complejo para cada método de pago.
- *Observer para el servicio de notificaciones:* Este patrón es necesario debido al estado cambainte de las reservas (pendiente, confirmada, cancelada), manteniendo la consistencia entre objetos relacionados en el sistema. 
- *Command para las operaciones de una reserva:* Este patrón encapsula operaciones como objetos manipulables, debido a que realizar una reserva involucra múltiples pasos. En la misma línea, estos pasos pueden fallar, por lo que gracias a Command podemos deshacherlas y reintentarlas.

