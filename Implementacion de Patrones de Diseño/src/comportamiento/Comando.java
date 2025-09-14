/**
 * Implementacion de patrondes de diseños de comportamiento: Command (Comando)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */

package comportamiento;

import creacionales.Reserva;
import java.util.Stack;
import creacionales.SistemaReservasSingleton;

// Interfaz Command: define las operaciones que deben implementar los comandos concretos
public interface Comando {
    void ejecutar();

    void deshacer();
}

// Comando concreto para realizar una reserva
public class ComandoReserva implements Comando {
    private Reserva reserva;
    private SistemaReservasSingleton sistema;
    private boolean ejecutado = false;

    // Constructor: recibe la reserva y obtiene la instancia única del sistema de reservas
    public ComandoReserva(Reserva reserva) {
        this.reserva = reserva;
        this.sistema = SistemaReservasSingleton.getInstance();
    }

    // Ejecuta la reserva y la agrega al sistema
    @Override
    public void ejecutar() {
        sistema.agregarReserva(reserva);
        ejecutado = true;
        System.out.println("Reserva ejecutada: " + reserva.getDescripcion());
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            // Lógica para deshacer la reserva
            System.out.println("Reserva deshecha: " + reserva.getDescripcion());
            ejecutado = false;
        }
    }
}

// Invocador: gestiona el historial de comandos y permite deshacer el último
public class Invocador {
    private Stack<Comando> historialComandos;

    public Invocador() {
        historialComandos = new Stack<>();
    }

    // Ejecuta un comando y lo guarda en el historial
    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historialComandos.push(comando);
    }

    // Deshace el último comando ejecutado
    public void deshacerUltimoComando() {
        if (!historialComandos.isEmpty()) {
            Comando comando = historialComandos.pop();
            comando.deshacer();
        }
    }
}