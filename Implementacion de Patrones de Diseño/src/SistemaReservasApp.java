/**
 * Clase principal del sistema de reservas en línea que integra varios patrones de diseño.
 * @author Hugo Jovel
 * @author Andrea Álvarez
 * @version 1.0
 * */
import comportamiento.ContextoPago;
import comportamiento.Invocador;

import java.util.*;
import estructurales.*;
import creacionales.*;
import comportamiento.*;

// Clase principal que maneja la interacción con el usuario y coordina los patrones de diseño
public class SistemaReservasApp {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaReservasFacade facade = new SistemaReservasFacade();
    private static ContextoPago contextoPago = new ContextoPago();
    private static Invocador invocador = new Invocador();
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE RESERVAS EN LÍNEA ===");
        
        while (true) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    crearReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    probarPatrones();
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el sistema!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Crear nueva reserva");
        System.out.println("2. Ver reservas existentes");
        System.out.println("3. Probar patrones de diseño");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static void crearReserva() {
        System.out.println("\n--- CREAR NUEVA RESERVA ---");
        
        // Datos del usuario
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Usuario usuario = new Usuario(nombre, email);
        
        // Tipo de servicio
        System.out.print("Tipo de servicio (hotel/vuelo/auto): ");
        String tipoServicio = scanner.nextLine();
        
        // Servicios extra
        List<String> extras = new ArrayList<>();
        System.out.print("¿Desea agregar seguro? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            extras.add("Seguro");
        }
        System.out.print("¿Desea agregar desayuno? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            extras.add("Desayuno");
        }
        
        // Método de pago
        System.out.print("Método de pago (tarjeta/paypal): ");
        String metodoPago = scanner.nextLine();
        
        // Crear reserva usando Facade
        Reserva reserva = facade.crearReservaCompleta(tipoServicio, extras, metodoPago, usuario);
        
        // Procesar pago usando Strategy
        EstrategiaPago estrategia = metodoPago.equalsIgnoreCase("paypal") ? 
            new PagoPayPal() : new PagoTarjetaCredito();
        contextoPago.setEstrategia(estrategia);
        contextoPago.ejecutarPago(reserva.getPrecioTotal());
        
        // Ejecutar comando
        Comando comando = new ComandoReserva(reserva);
        invocador.ejecutarComando(comando);
        
        System.out.println("¡Reserva creada exitosamente!");
    }
    
    private static void mostrarReservas() {
        SistemaReservasSingleton sistema = SistemaReservasSingleton.getInstance();
        List<Reserva> reservas = sistema.getReservas();
        
        System.out.println("\n--- RESERVAS EXISTENTES ---");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas existentes");
        } else {
            for (int i = 0; i < reservas.size(); i++) {
                Reserva reserva = reservas.get(i);
                System.out.println((i + 1) + ". " + reserva.getDescripcion() + 
                                 " - $" + reserva.getPrecioTotal());
            }
        }
    }
    
    private static void probarPatrones() {
        System.out.println("\n--- DEMOSTRACIÓN DE PATRONES ---");
        
        // Demo Factory Method
        System.out.println("\n1. Factory Method:");
        ServicioFactory hotelFactory = ServicioFactory.getFactory("hotel");
        ServicioReserva hotel = hotelFactory.crearServicio();
        System.out.println("Servicio creado: " + hotel.getDescripcion());
        
        // Demo Decorator
        System.out.println("\n2. Decorator:");
        ServicioReserva vueloConExtras = new SeguroDecorator(new VueloService());
        vueloConExtras = new DesayunoDecorator(vueloConExtras);
        System.out.println("Servicio decorado: " + vueloConExtras.getDescripcion());
        System.out.println("Precio total: $" + vueloConExtras.getPrecio());
        
        // Demo Adapter
        System.out.println("\n3. Adapter:");
        ServicioExterno servicioExterno = new ServicioExternoHotel();
        ServicioReserva servicioAdaptado = new ServicioExternoAdapter(servicioExterno);
        servicioAdaptado.reservar();
        
        // Demo Command (deshacer)
        System.out.println("\n4. Command:");
        System.out.print("¿Desea deshacer la última reserva? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            invocador.deshacerUltimoComando();
        }
    }
}