/**
 * Implementacion de patrondes de diseños creacionales: Builder (Constructor)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */

package creacionales;

import java.util.ArrayList;
import java.util.List;

//Clase que representa una reserva de un servicio, utilizando el patrón Builder
public class Reserva {
    private ServicioReserva servicio;
    private List<String> serviciosExtra;
    private String metodoPago;
    private double precioTotal;

    //Constructores privados para forzar el uso del Builder
    private Reserva() {
        serviciosExtra = new ArrayList<>();
    }
    
    // Getters
    public static class Builder {
        private Reserva reserva;
        
        public Builder() {
            reserva = new Reserva();
        }

        // Métodos para configurar la reserva
        public Builder setServicio(ServicioReserva servicio) {
            reserva.servicio = servicio;
            reserva.precioTotal = servicio.getPrecio();
            return this;
        }
        // Metodo para agregar servicios extra
        public Builder agregarServicioExtra(String servicioExtra, double precio) {
            reserva.serviciosExtra.add(servicioExtra + " - $" + precio);
            reserva.precioTotal += precio;
            return this;
        }

        // Metodo para establecer el metodo de pago
        public Builder setMetodoPago(String metodoPago) {
            reserva.metodoPago = metodoPago;
            return this;
        }

        // Metodo para construir la reserva
        public Reserva build() {
            if (reserva.servicio == null) {
                throw new IllegalStateException("Debe especificar un servicio");
            }
            return reserva;
        }
    }
}