/**
 * Implementacion de patrondes de diseños de comportamiento: Strategy (Estrategia)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */

package comportamiento;

// Estrategia de Pago: Permite seleccionar diferentes métodos de pago en tiempo de ejecución.
public interface EstrategiaPago {
    boolean pagar(double monto);

    String getNombre();
}

// Implementaciones concretas de la estrategia
public class PagoTarjetaCredito implements EstrategiaPago {
    @Override
    public boolean pagar(double monto) {
        System.out.println("Pagando $" + monto + " con Tarjeta de Crédito");
        return true;
    }

    @Override
    public String getNombre() {
        return "Tarjeta de Crédito";
    }
}


public class PagoPayPal implements EstrategiaPago {
    @Override
    public boolean pagar(double monto) {
        System.out.println("Pagando $" + monto + " con PayPal");
        return true;
    }

    @Override
    public String getNombre() {
        return "PayPal";
    }
}

//Contexto que utiliza la estrategia, permitiendo cambiarla en tiempo de ejecución
public class ContextoPago {
    private EstrategiaPago estrategia;

    public void setEstrategia(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }

    public boolean ejecutarPago(double monto) {
        if (estrategia == null) {
            throw new IllegalStateException("Estrategia de pago no configurada");
        }
        return estrategia.pagar(monto);
    }
}