public class HistorialMedico implements Cloneable {
    private int id;
    private String nombrePaciente;
    private String diagnostico;
    private String tratamiento;

    public HistorialMedico(int id, String nombrePaciente, String diagnostico, String tratamiento) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    // Método para clonar el historial médico
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Métodos para modificar variaciones
    public HistorialMedico clonarConVariaciones(String nuevoDiagnostico, String nuevoTratamiento) throws CloneNotSupportedException {
        HistorialMedico clon = (HistorialMedico) this.clone();
        clon.setDiagnostico(nuevoDiagnostico);
        clon.setTratamiento(nuevoTratamiento);
        return clon;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "HistorialMedico{" +
                "id=" + id +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                '}';
    }
}
