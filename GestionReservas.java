package co.edu.ucc.CarlosParedes.Builder;

import java.util.Base64;
import java.util.Scanner;

// Encabezado personalizado del programa
public class GestionReservas {

    // Metodo para codificar el nombre completo en Base64
    public static String getIdentidad() {
        String nombreCompleto = "Carlos Paredes"; // Cambia esto por tu nombre completo
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("*  Universidad Cooperativa de Colombia  *");
        System.out.println("*  Facultad de Ingeniería               *");
        System.out.println("*  Asignatura: Patrones de Diseño       *");
        System.out.println("*  Docente: Harold Bolaños              *");
        System.out.println("*  Fecha: 2025-03-11                    *");
        System.out.println("*****************************************");
        // Mostrar encabezado personalizado
        System.out.println("=== Sistema de Gestión de Reservas de Vuelos ===");
        System.out.println("Identidad del desarrollador (Base64): " + getIdentidad());

        Scanner scanner = new Scanner(System.in);

        // Elegir clase de vuelo
        System.out.println("\nSeleccione la clase de vuelo:");
        System.out.println("1. Económica");
        System.out.println("2. Ejecutiva");
        System.out.println("3. Primera Clase");
        System.out.print("Opción: ");
        int claseOpcion = scanner.nextInt();

        String clase;
        switch (claseOpcion) {
            case 1:
                clase = "Económica";
                break;
            case 2:
                clase = "Ejecutiva";
                break;
            case 3:
                clase = "Primera Clase";
                break;
            default:
                System.out.println("Opción no válida. Saliendo del programa...");
                scanner.close();
                return;
        }

        // Crear el Builder para el boleto
        Boleto.BoletoBuilder builder = new Boleto.BoletoBuilder(clase);

        // Elegir servicios adicionales
        System.out.println("\n¿Desea agregar equipaje extra? (1: Sí, 2: No)");
        if (scanner.nextInt() == 1) {
            builder.agregarEquipajeExtra();
        }

        System.out.println("¿Desea seleccionar su asiento? (1: Sí, 2: No)");
        if (scanner.nextInt() == 1) {
            builder.seleccionarAsiento();
        }

        System.out.println("¿Desea agregar comida especial? (1: Sí, 2: No)");
        if (scanner.nextInt() == 1) {
            builder.agregarComidaEspecial();
        }

        // Construir el boleto personalizado
        Boleto boleto = builder.build();

        // Mostrar detalles del boleto
        System.out.println("\nDetalles del boleto personalizado:");
        boleto.mostrarDetalles();

        scanner.close();
    }
}

// Clase Boleto que representa un boleto de vuelo
class Boleto {
    private String clase; // Clase del vuelo
    private boolean equipajeExtra; // Servicio de equipaje extra
    private boolean seleccionAsiento; // Servicio de selección de asiento
    private boolean comidaEspecial; // Servicio de comida especial

    // Constructor privado (utilizado por el Builder)
    private Boleto(BoletoBuilder builder) {
        this.clase = builder.clase;
        this.equipajeExtra = builder.equipajeExtra;
        this.seleccionAsiento = builder.seleccionAsiento;
        this.comidaEspecial = builder.comidaEspecial;
    }

    // Metodo para mostrar los detalles del boleto
    public void mostrarDetalles() {
        System.out.println("Clase: " + clase);
        System.out.println("Equipaje Extra: " + (equipajeExtra ? "Sí" : "No"));
        System.out.println("Selección de Asiento: " + (seleccionAsiento ? "Sí" : "No"));
        System.out.println("Comida Especial: " + (comidaEspecial ? "Sí" : "No"));
    }

    // Clase estática Builder para construir objetos Boleto
    public static class BoletoBuilder {
        private String clase;
        private boolean equipajeExtra;
        private boolean seleccionAsiento;
        private boolean comidaEspecial;

        // Constructor del Builder con el parámetro obligatorio (clase del vuelo)
        public BoletoBuilder(String clase) {
            this.clase = clase;
        }

        // Metodo para agregar servicio de equipaje extra
        public BoletoBuilder agregarEquipajeExtra() {
            this.equipajeExtra = true;
            return this;
        }

        // Metodo para agregar servicio de selección de asiento
        public BoletoBuilder seleccionarAsiento() {
            this.seleccionAsiento = true;
            return this;
        }

        // Metodo para agregar servicio de comida especial
        public BoletoBuilder agregarComidaEspecial() {
            this.comidaEspecial = true;
            return this;
        }

        // Metodo para construir el objeto Boleto
        public Boleto build() {
            return new Boleto(this);
        }
    }
}
