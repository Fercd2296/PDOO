// Clase Auto con algunas configuraciones básicas
public class Auto {
    private String motor;
    private String sistemaAudio;
    private boolean sensoresProximidad;

    // Constructor privado para usar con el Builder
    private Auto(AutoBuilder builder) {
        this.motor = builder.motor;
        this.sistemaAudio = builder.sistemaAudio;
        this.sensoresProximidad = builder.sensoresProximidad;
    }

    // Clase Builder para construir objetos Auto
    public static class AutoBuilder {
        // Atributos públicos para simplicidad
        public String motor;
        public String sistemaAudio;
        public boolean sensoresProximidad;

        // Métodos para configurar cada atributo (uno por uno)
        public AutoBuilder setMotor(String motor) {
            this.motor = motor;
            return this;
        }

        public AutoBuilder setSistemaAudio(String sistemaAudio) {
            this.sistemaAudio = sistemaAudio;
            return this;
        }

        public AutoBuilder setSensoresProximidad(boolean sensoresProximidad) {
            this.sensoresProximidad = sensoresProximidad;
            return this;
        }

        // Método para crear el objeto Auto
        public Auto build() {
            return new Auto(this);
        }
    }

    @Override
    public String toString() {
        return "Auto con motor: " + motor + ", sistema de audio: " + sistemaAudio +
                ", sensores de proximidad: " + sensoresProximidad;
    }

    public static void main(String[] args) {
        // Ejemplo de uso del Builder
        Auto auto1 = new Auto.AutoBuilder()
                .setMotor("Eléctrico")
                .setSistemaAudio("Estándar")
                .setSensoresProximidad(false)
                .build();

        Auto auto2 = new Auto.AutoBuilder()
                .setMotor("Gasolina")
                .setSistemaAudio("Premium")
                .setSensoresProximidad(true)
                .build();

        System.out.println(auto1);
        System.out.println(auto2);
    }
}