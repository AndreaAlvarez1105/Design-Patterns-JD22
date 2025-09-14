/**
 * Implementacion de patrondes de diseños de comportamiento: Observer (Observador)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */
package comportamiento;

import java.util.ArrayList;
import java.util.List;

// Interfaz Observer: define el método que deben implementar los observadores
public interface Observador {
    void actualizar(String mensaje);
}

// Clase concreta que representa a un usuario observador
public class Usuario implements Observador {
    private String nombre;
    private String email;

    // Constructor: inicializa nombre y email del usuario
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Método llamado cuando el usuario recibe una notificación
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para " + nombre + " (" + email + "): " + mensaje);
    }
}

public class NotificadorReserva {
    private List<Observador> observadores;

    // Constructor: inicializa la lista de observadores
    public NotificadorReserva() {
        observadores = new ArrayList<>();
    }

    // Agrega un observador a la lista
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    // Elimina un observador de la lista
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    // Notifica a todos los observadores con el mensaje dado
    public void notificar(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}