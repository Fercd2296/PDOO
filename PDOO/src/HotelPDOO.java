import java.util.*;

// Simulación de base de datos local optimizada con tarifas predeterminadas para ciudades frías y calientes
class DatabaseManager {
    public static double getPrecio(String tipoCiudad, String tipoHabitacion) {
        double precio = -1.0;
        if (tipoCiudad.equals("caliente")) {
            if (tipoHabitacion.equals("suite normal")) {
                precio = 120000.0;
            } else if (tipoHabitacion.equals("suite vip")) {
                precio = 450000.0;
            } else if (tipoHabitacion.equals("penthouse")) {
                precio = 1000000.0;
            }
        } else if (tipoCiudad.equals("fría")) {
            if (tipoHabitacion.equals("suite normal")) {
                precio = 180000.0;
            } else if (tipoHabitacion.equals("suite vip")) {
                precio = 520000.0;
            } else if (tipoHabitacion.equals("penthouse")) {
                precio = 2500000.0;
            }
        }
        return precio;
    }
}

// Interfaz para la reserva de hotel
interface Reserva {
    void realizarReserva();
}

// Implementación de la reserva
class ReservaHotel implements Reserva {
    private final String cliente;
    private final String telefono;
    private final String documento;
    private final String tipoCiudad;
    private final String tipoHabitacion;
    private final double precio;

    public ReservaHotel(String cliente, String telefono, String documento, String tipoCiudad, String tipoHabitacion) {
        this.cliente = cliente;
        this.telefono = telefono;
        this.documento = documento;
        this.tipoCiudad = tipoCiudad;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = DatabaseManager.getPrecio(tipoCiudad, tipoHabitacion);
    }

    @Override
    public void realizarReserva() {
        if (precio == -1) {
            System.out.println("No se encontró información de precios para esta reserva.");
        } else {
            System.out.println("\nReserva realizada con éxito:");
            System.out.println("Cliente: " + cliente);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Documento: " + documento);
            System.out.println("Tipo de ciudad: " + tipoCiudad);
            System.out.println("Habitación: " + tipoHabitacion);
            System.out.println("Precio: $" + precio);
        }
    }
}

// Factory Method para la creación de reservas
class ReservaFactory {
    public static Reserva crearReserva(String cliente, String telefono, String documento, String tipoCiudad, String tipoHabitacion) {
        return new ReservaHotel(cliente, telefono, documento, tipoCiudad, tipoHabitacion);
    }
}

// Facade para simplificar la reserva
class HotelFacade {
    public void reservarHabitacion(String cliente, String telefono, String documento, String tipoCiudad, String tipoHabitacion) {
        Reserva reserva = ReservaFactory.crearReserva(cliente, telefono, documento, tipoCiudad, tipoHabitacion);
        reserva.realizarReserva();
    }
}

// Clase principal con menú interactivo
public class HotelPDOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelFacade facade = new HotelFacade();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Reservas ---");
            System.out.println("1. Realizar reserva");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
                continue;
            }
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Ingrese su nombre: ");
                String cliente = scanner.nextLine();

                System.out.print("Ingrese su teléfono: ");
                String telefono = scanner.nextLine();

                System.out.print("Ingrese su número de documento: ");
                String documento = scanner.nextLine();

                System.out.println("Seleccione el tipo de ciudad:");
                System.out.println("1. Caliente");
                System.out.println("2. Fría");

                int opcionCiudad = scanner.nextInt();
                scanner.nextLine();
                String tipoCiudad = opcionCiudad == 1 ? "caliente" : "fría";

                System.out.println("Seleccione el tipo de habitación:");
                System.out.println("1. Suite Normal");
                System.out.println("2. Suite VIP");
                System.out.println("3. Penthouse");

                int opcionHabitacion = scanner.nextInt();
                scanner.nextLine();
                String tipoHabitacion = "";

                if (opcionHabitacion == 1) {
                    tipoHabitacion = "suite normal";
                } else if (opcionHabitacion == 2) {
                    tipoHabitacion = "suite vip";
                } else if (opcionHabitacion == 3) {
                    tipoHabitacion = "penthouse";
                } else {
                    System.out.println("Opción de habitación no válida. Intente nuevamente.");
                    continue;
                }

                facade.reservarHabitacion(cliente, telefono, documento, tipoCiudad, tipoHabitacion);
            } else if (opcion == 2) {
                salir = true;
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción no válida, intente nuevamente.");
            }
        }
        scanner.close();
    }
}
