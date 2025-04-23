// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        try {
            HistorialMedico original = new HistorialMedico(1, "Juan Pérez", "Gripe", "Paracetamol");
            HistorialMedico modificado = original.clonarConVariaciones("Resfriado", "Ibuprofeno");

            System.out.println("Original: " + original);
            System.out.println("Modificado: " + modificado);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}