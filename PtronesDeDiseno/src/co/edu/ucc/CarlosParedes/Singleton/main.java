package co.edu.ucc.CarlosParedes.Singleton;

import java.util.Scanner;

import static co.edu.ucc.CarlosParedes.Singleton.PatronSingleton.getIdentidad;
import static co.edu.ucc.CarlosParedes.Singleton.PatronSingleton.mostrarEncabezado;

public class main {

    public static void main(String[] args) {
        mostrarEncabezado();
        Scanner scanner = new Scanner(System.in);
        PatronSingleton.Logger logger = PatronSingleton.Logger.getInstance();

        int opcion;
        do {
            // Mostrar menú de opciones
            System.out.println("Menú:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Realizar transacción");
            System.out.println("3. Ver identidad");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            // Ejecutar acciones según la opción seleccionada
            switch(opcion) {
                case 1:
                    logger.log("Inicio de sesión");
                    break;
                case 2:
                    logger.log("Transacción realizada");
                    break;
                case 3:
                    System.out.println("Identidad codificada: " + getIdentidad());
                    break;
                case 4:
                    logger.log("Saliendo del programa");
                    System.out.println("Identidad codificada al finalizar: " + getIdentidad());
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
