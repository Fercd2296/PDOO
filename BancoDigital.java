package co.edu.ucc.CarlosParedes.FactoryMethod;

import java.util.Base64;
import java.util.Scanner;

// Encabezado personalizado del programa
public class BancoDigital {

    // Metodo para codificar el nombre completo en Base64
    public static String getIdentidad() {
        System.out.println("*****************************************");
        System.out.println("*  Universidad Cooperativa de Colombia  *");
        System.out.println("*  Facultad de Ingeniería               *");
        System.out.println("*  Asignatura: Patrones de Diseño       *");
        System.out.println("*  Docente: Harold Bolaños              *");
        System.out.println("*  Fecha: 2025-03-11                    *");
        System.out.println("*****************************************");
        String nombreCompleto = "Carlos Paredes";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static void main(String[] args) {
        // Mostrar encabezado personalizado
        System.out.println("=== Sistema de Préstamos del Banco Digital ===");
        System.out.println("Identidad del desarrollador (Base64): " + getIdentidad());

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSeleccione el tipo de préstamo que desea solicitar:");
        System.out.println("1. Hipotecario");
        System.out.println("2. Automotriz");
        System.out.println("3. Personal");
        System.out.print("Opción: ");

        String tipo = "";
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                tipo = "hipotecario";
                break;
            case 2:
                tipo = "automotriz";
                break;
            case 3:
                tipo = "personal";
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                scanner.close();
                return;
        }

        // Crear el préstamo seleccionado
        Prestamo prestamo = FabricaPrestamo.obtenerPrestamo(tipo);

        // Mostrar detalles del préstamo
        System.out.println("\nDetalles del préstamo seleccionado:");
        prestamo.mostrarDetalles();

        // Aplicar y mostrar reglas de negocio
        System.out.println("\nAplicando las reglas de negocio:");
        prestamo.aplicarReglasDeNegocio();

        scanner.close();
    }
}

// Interfaz para los préstamos
interface Prestamo {
    void mostrarDetalles();
    void aplicarReglasDeNegocio(); // Metodo para reglas de negocio específicas
}

// Implementación para Préstamo Hipotecario
class PrestamoHipotecario implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Hipotecario: tasa 5%, plazo 30 años.");
    }

    @Override
    public void aplicarReglasDeNegocio() {
        System.out.println("Reglas de negocio: Debe presentar documentos de propiedad y reporte de ingresos.");
    }
}

// Implementación para Préstamo Automotriz
class PrestamoAutomotriz implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Automotriz: tasa 7%, plazo 5 años.");
    }

    @Override
    public void aplicarReglasDeNegocio() {
        System.out.println("Reglas de negocio: Requiere seguro del vehículo y un pago inicial del 20%.");
    }
}

// Implementación para Préstamo Personal
class PrestamoPersonal implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Personal: tasa 10%, plazo 3 años.");
    }

    @Override
    public void aplicarReglasDeNegocio() {
        System.out.println("Reglas de negocio: Solo disponible para clientes con historial crediticio aprobado.");
    }
}

// Fábrica de Préstamos (Factory Method)
class FabricaPrestamo {
    public static Prestamo obtenerPrestamo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hipotecario":
                return new PrestamoHipotecario();
            case "automotriz":
                return new PrestamoAutomotriz();
            case "personal":
                return new PrestamoPersonal();
            default:
                throw new IllegalArgumentException("Tipo de préstamo no válido");
        }
    }
}
