package co.edu.ucc.CarlosParedes.Seccion7.Ejercicios.GestiónParqueDiversiones;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Base64;

class EquipoVR {
    private String id;
    private String idCodificado = codificarBase64("Carlos Paredes");

    public EquipoVR(String id) {
        this.id = id;
        System.out.println("Nuevo equipo VR disponible: " + id);
    }

    public void asignarUsuario(String usuario) {
        System.out.println("Equipo VR " + id + " asignado a " + usuario);
    }

    public String getIdCodificado() {
        return idCodificado;
    }

    private String codificarBase64(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes());
    }
}

class PoolEquiposVR {
    private Queue<EquipoVR> pool;
    private int limite;

    public PoolEquiposVR(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new EquipoVR("VR-" + (i + 1)));
        }
    }

    public EquipoVR obtenerEquipo() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay equipos VR disponibles, espere...");
            return null;
        }
    }

    public void liberarEquipo(EquipoVR equipo) {
        pool.offer(equipo);
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

        
        PoolEquiposVR pool = new PoolEquiposVR(3);

        EquipoVR e1 = pool.obtenerEquipo();
        EquipoVR e2 = pool.obtenerEquipo();

        e1.asignarUsuario("Carlos");
        pool.liberarEquipo(e1);

        EquipoVR e3 = pool.obtenerEquipo();
        e3.asignarUsuario("Ana");

        // Mostrar el nombre codificado al final
        System.out.println("Nombre codificado: " + e1.getIdCodificado());
    }
}
