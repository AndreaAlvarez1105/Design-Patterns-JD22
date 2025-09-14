/**
 * Implementacion de patrondes de diseños estructurales: Adapter (Adaptador)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */

package estructurales;

import creacionales.ServicioReserva;

// Interfaz que define las operaciones comunes para cualquier servicio de reserva
public interface ServicioExterno {
    String realizarReservaExterna();
    double obtenerPrecioExterno();
}

// Implementación concreta de un servicio externo (por ejemplo, un sistema de reservas de hotel externo)
public class ServicioExternoHotel implements ServicioExterno {
    @Override
    public String realizarReservaExterna() {
        return "Reserva externa de hotel confirmada";
    }
    
    @Override
    public double obtenerPrecioExterno() {
        return 200.0;
    }
}

// Adaptador que permite usar un servicio externo como un ServicioReserva
public class ServicioExternoAdapter implements ServicioReserva {
    private ServicioExterno servicioExterno;
    
    public ServicioExternoAdapter(ServicioExterno servicioExterno) {
        this.servicioExterno = servicioExterno;
    }

    //Reserva utilizando el servicio externo
    @Override
    public void reservar() {
        System.out.println(servicioExterno.realizarReservaExterna());
    }

    //Obtiene el precio desde el servicio externo
    @Override
    public double getPrecio() {
        return servicioExterno.obtenerPrecioExterno();
    }

    // Proporciona una descripción del servicio adaptado
    @Override
    public String getDescripcion() {
        return "Servicio externo adaptado";
    }
}