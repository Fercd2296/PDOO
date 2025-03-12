package co.edu.ucc.CarlosParedes.Seccion7.Ejercicios.GestiónCamillasHospital;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Base64;

class Camilla {
    private String id;
    private String idCodificado = codificarBase64("Carlos Paredes");

    public Camilla(String id) {
        this.id = id;
        System.out.println("Nueva camilla disponible: " + id);
    }

    public void asignarPaciente(String paciente) {
        System.out.println("Camilla " + id + " asignada a paciente " + paciente);
    }

    public String getIdCodificado() {
        return idCodificado;
    }

    private String codificarBase64(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes());
    }
}

class PoolCamillas {
    private Queue<Camilla> pool;
    private int limite;

    public PoolCamillas(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new Camilla("Camilla-" + (i + 1)));
        }
    }

    public Camilla obtenerCamilla() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay camillas disponibles, espere...");
            return null;
        }
    }

    public void liberarCamilla(Camilla camilla) {
        pool.offer(camilla);
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

        
        PoolCamillas pool = new PoolCamillas(3);

        Camilla c1 = pool.obtenerCamilla();
        Camilla c2 = pool.obtenerCamilla();

        c1.asignarPaciente("María");
        pool.liberarCamilla(c1);

        Camilla c3 = pool.obtenerCamilla();
        c3.asignarPaciente("Pedro");

        // Mostrar el nombre codificado al final
        System.out.println("Nombre codificado: " + c1.getIdCodificado());
    }
}
