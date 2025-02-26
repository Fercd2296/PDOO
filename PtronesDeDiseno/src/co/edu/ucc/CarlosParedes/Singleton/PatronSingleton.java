package co.edu.ucc.CarlosParedes.Singleton;

import java.util.Base64;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PatronSingleton {

    // Clase interna Logger para implementar el patrón Singleton
    static class Logger {
        private static Logger instance;
        private Logger() {}

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("[LOG] " + message);
        }
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
