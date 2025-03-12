import java.util.Queue;
import java.util.LinkedList;
import java.util.Base64;

// Clase que representa una conexión a la base de datos
class ConexionDB {
    private String id;
    private String idCodificado = codificarBase64("Carlos Paredes");

    public ConexionDB(String id) {
        this.id = id;
        System.out.println("Nueva conexión creada: " + id);
    }

    public void ejecutarConsulta(String consulta) {
        System.out.println("Ejecutando consulta en " + id + ": " + consulta);
    }

    public String getIdCodificado() {
        return idCodificado;
    }

    private String codificarBase64(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes());
    }
}

// Implementación del Object Pool
class PoolConexiones {
    private Queue<ConexionDB> pool;
    private int limite;

    public PoolConexiones(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new ConexionDB("Conexion-" + (i + 1)));
        }
    }

    public ConexionDB obtenerConexion() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay conexiones disponibles, espere...");
            return null;
        }
    }

    public void liberarConexion(ConexionDB conexion) {
        pool.offer(conexion);
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

        PoolConexiones pool = new PoolConexiones(2);

        ConexionDB c1 = pool.obtenerConexion();
        ConexionDB c2 = pool.obtenerConexion();
        ConexionDB c3 = pool.obtenerConexion(); // No hay conexiones disponibles

        c1.ejecutarConsulta("SELECT * FROM usuarios");
        pool.liberarConexion(c1);

        ConexionDB c4 = pool.obtenerConexion(); // Ahora sí hay conexión disponible
        c4.ejecutarConsulta("INSERT INTO transacciones VALUES (1, 100)");

        // Mostrar el nombre codificado al final
        System.out.println("Nombre codificado: " + c1.getIdCodificado());
    }
}
