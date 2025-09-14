/**
 * Implementacion de patrondes de diseños creacionales: Singleton
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */
import creacionales.Reserva;

import java.util.ArrayList;
import java.util.List;

// Singleton que gestiona todas las reservas
public class SistemaReservasSingleton {
    private static SistemaReservasSingleton instance;
    private List<Reserva> reservas;

    // Constructor privado para evitar instanciación externa
    private SistemaReservasSingleton() {
        reservas = new ArrayList<>();
    }

    // Metodo para obtener la instancia única del singleton
    public static synchronized SistemaReservasSingleton getInstance() {
        if (instance == null) {
            instance = new SistemaReservasSingleton();
        }
        return instance;
    }

    // Metodo para agregar una reserva al sistema
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // Metodo para obtener todas las reservas
    public List<Reserva> getReservas() {
        return new ArrayList<>(reservas);
    }
}