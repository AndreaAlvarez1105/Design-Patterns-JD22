/**
 * Implementacion de patrondes de diseños creacionales: Factory Method (Metodo de Fábrica)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */
package creacionales;

// Interfaz que define las operaciones comunes para cualquier servicio de reserva
public interface ServicioReserva {
    void reservar();
    double getPrecio();
    String getDescripcion();
}

// Implementación concreta para reservas de hotel
public class HotelService implements ServicioReserva {
    @Override
    public void reservar() {
        System.out.println("Reserva de hotel realizada");
    }
    
    @Override
    public double getPrecio() {
        return 150.0;
    }
    
    @Override
    public String getDescripcion() {
        return "Reserva de Hotel - 3 noches";
    }
}

// Implementación concreta para reservas de vuelo
public class VueloService implements ServicioReserva {
    @Override
    public void reservar() {
        System.out.println("Reserva de vuelo realizada");
    }
    
    @Override
    public double getPrecio() {
        return 300.0;
    }
    
    @Override
    public String getDescripcion() {
        return "Reserva de Vuelo - Ida y vuelta";
    }
}

// Implementación concreta para alquiler de autos
public class AutoService implements ServicioReserva {
    @Override
    public void reservar() {
        System.out.println("Reserva de auto realizada");
    }
    
    @Override
    public double getPrecio() {
        return 80.0;
    }
    
    @Override
    public String getDescripcion() {
        return "Alquiler de Auto - 3 días";
    }
}

// Clase abstracta que define el metodo para crear servicios
public abstract class ServicioFactory {
    public abstract ServicioReserva crearServicio();

    // Metodo estático para obtener la fábrica adecuada según el tipo
    public static ServicioFactory getFactory(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hotel": return new HotelFactory();
            case "vuelo": return new VueloFactory();
            case "auto": return new AutoFactory();
            default: throw new IllegalArgumentException("Tipo de servicio no válido");
        }
    }
}

// Fábrica concreta para crear servicios de hotel
public class HotelFactory extends ServicioFactory {
    @Override
    public ServicioReserva crearServicio() {
        return new HotelService();
    }
}

// Fábrica concreta para crear servicios de vuelo
public class VueloFactory extends ServicioFactory {
    @Override
    public ServicioReserva crearServicio() {
        return new VueloService();
    }
}

// Fábrica concreta para crear servicios de auto
public class AutoFactory extends ServicioFactory {
    @Override
    public ServicioReserva crearServicio() {
        return new AutoService();
    }
}