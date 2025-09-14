/**
 * Implementacion de patrondes de diseños estructurales: Decorator (Decorador)
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */

// Clase abstracta base para los decoradores, permite envolver servicios y añadir funcionalidades
public abstract class ServicioDecorator implements ServicioReserva {
    protected ServicioReserva servicioDecorado;
    
    public ServicioDecorator(ServicioReserva servicio) {
        this.servicioDecorado = servicio;
    }

    // Delegación de la reserva al servicio original
    @Override
    public void reservar() {
        servicioDecorado.reservar();
    }

    // Delegación del precio al servicio original
    @Override
    public double getPrecio() {
        return servicioDecorado.getPrecio();
    }

    // Delegación de la descripción al servicio original
    @Override
    public String getDescripcion() {
        return servicioDecorado.getDescripcion();
    }
}

// Decorador concreto que añade seguro al servicio de reserva
public class SeguroDecorator extends ServicioDecorator {
    public SeguroDecorator(ServicioReserva servicio) {
        super(servicio);
    }
    
    @Override
    public void reservar() {
        super.reservar();
        System.out.println("Seguro agregado a la reserva");
    }

    // Suma el costo del seguro al precio original
    @Override
    public double getPrecio() {
        return super.getPrecio() + 30.0;
    }

    // Añade la información de seguro a la descripción
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Seguro";
    }
}

// Decorador concreto que añade desayuno al servicio de reserva
public class DesayunoDecorator extends ServicioDecorator {
    public DesayunoDecorator(ServicioReserva servicio) {
        super(servicio);
    }

    // Añade mensaje de desayuno al reservar
    @Override
    public void reservar() {
        super.reservar();
        System.out.println("Desayuno incluido");
    }

    // Suma el costo del desayuno al precio original
    @Override
    public double getPrecio() {
        return super.getPrecio() + 20.0;
    }

    // Añade la información de desayuno a la descripción
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Desayuno";
    }
}