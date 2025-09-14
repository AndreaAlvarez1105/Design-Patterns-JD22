/**
 * Implementacion de patrondes de diseños estructurales: Facade (Fachada)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */
package estructurales;

import comportamiento.NotificadorReserva;
import comportamiento.Usuario;
import creacionales.ServicioFactory;
import creacionales.ServicioReserva;

import java.util.List;

// Facade que simplifica la interacción con el sistema de reservas
public class SistemaReservasFacade<Reserva> {
    private SistemaReservasSingleton sistema;
    private NotificadorReserva notificador;
    
    public SistemaReservasFacade() {
        sistema = SistemaReservasSingleton.getInstance();
        notificador = new NotificadorReserva();
    }

    // Metodo simplificado para crear una reserva completa
    public Reserva crearReservaCompleta(String tipoServicio, List<String> extras,
                                      String metodoPago, Usuario usuario) {
        // Factory Method
        ServicioFactory factory = ServicioFactory.getFactory(tipoServicio);
        ServicioReserva servicio = factory.crearServicio();
        
        // Builder
        Reserva.Builder builder = new Reserva.Builder()
            .setServicio(servicio)
            .setMetodoPago(metodoPago);
        
        // Decorator (simulado en el builder)
        for (String extra : extras) {
            builder.agregarServicioExtra(extra, 25.0); // Precio fijo para extras
        }
        
        Reserva reserva = builder.build();
        
        // Singleton
        sistema.agregarReserva(reserva);
        
        // Observer
        notificador.agregarObservador(usuario);
        notificador.notificar("Reserva creada: " + servicio.getDescripcion());
        
        return reserva;
    }
}