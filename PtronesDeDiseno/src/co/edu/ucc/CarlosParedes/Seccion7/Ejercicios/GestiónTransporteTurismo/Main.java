package co.edu.ucc.CarlosParedes.Seccion7.Ejercicios.GestiónTransporteTurismo;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Base64;

class VehiculoTuristico {
    private String id;
    private String idCodificado = codificarBase64("Carlos Paredes");

    public VehiculoTuristico(String id) {
        this.id = id;
        System.out.println("Nuevo vehículo disponible: " + id);
    }

    public void asignarRecorrido(String recorrido) {
        System.out.println("Vehículo " + id + " asignado a " + recorrido);
    }

    public String getIdCodificado() {
        return idCodificado;
    }

    private String codificarBase64(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes());
    }
}

class PoolVehiculos {
    private Queue<VehiculoTuristico> pool;
    private int limite;

    public PoolVehiculos(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new VehiculoTuristico("Vehiculo-" + (i + 1)));
        }
    }

    public VehiculoTuristico obtenerVehiculo() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay vehículos disponibles, espere...");
            return null;
        }
    }

    public void liberarVehiculo(VehiculoTuristico vehiculo) {
        pool.offer(vehiculo);
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("*****************************************");
        System.out.println("*  Universidad Cooperativa de Colombia  *");
        System.out.println("*  Facultad de Ingeniería               *");
        System.out.println("*  Asignatura: Patrones de Diseño       *");
        System.out.println("*  Docente: Harold Bolaños              *");
        System.out.println("*  Fecha: 2025-03-18                    *");
        System.out.println("*****************************************");


        PoolVehiculos pool = new PoolVehiculos(2);

        VehiculoTuristico v1 = pool.obtenerVehiculo();
        VehiculoTuristico v2 = pool.obtenerVehiculo();
        VehiculoTuristico v3 = pool.obtenerVehiculo(); // No hay vehículos disponibles

        v1.asignarRecorrido("Tour por la ciudad");
        pool.liberarVehiculo(v1);

        VehiculoTuristico v4 = pool.obtenerVehiculo(); // Ahora hay uno disponible
        v4.asignarRecorrido("Visita a las montañas");

        // Mostrar el nombre codificado al final
        System.out.println("Nombre codificado: " + v1.getIdCodificado());
    }
}
