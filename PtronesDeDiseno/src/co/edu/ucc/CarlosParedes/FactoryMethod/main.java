package co.edu.ucc.CarlosParedes.FactoryMethod;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

import static co.edu.ucc.CarlosParedes.Singleton.PatronSingleton.getIdentidad;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija el tipo de vehículo:");
        System.out.println("1. Eléctrico");
        System.out.println("2. Gasolina");
        System.out.print("Ingrese su elección: ");

        int eleccion = scanner.nextInt();
        Vehiculo vehiculo = null;

        switch (eleccion) {
            case 1:
                vehiculo = FabricaVehiculos.crearVehiculo("electrico");
                break;
            case 2:
                vehiculo = FabricaVehiculos.crearVehiculo("gasolina");
                break;
            default:
                System.out.println("Elección inválida");
                System.exit(0);
        }

        vehiculo.conducir();
        System.out.println("Identidad codificada: " + getIdentidad());
    }

    // Metodo para mostrar emcabezado
    public static void mostrarEncabezado() {
        String nombre = "Carlos Paredes";
        String universidad = "Universidad Cooperativa de Colombia";
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        System.out.println("Nombre: " + nombre);
        System.out.println("Universidad: " + universidad);
        System.out.println("Fecha: " + fecha);
        System.out.println("------------------------------------------");
    }

    // Identidad codificad en base64
    public static String getIdentidad() {
        String nombreCompleto = "Carlos Paredes";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }


}

