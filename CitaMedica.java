public class CitaMedica {

    private Fecha fechaCita;
    private String veterinario;
    private String disgnostico;
    private String medicacion;
    private String recomendaciones;

    public CitaMedica(Fecha fechaCita, String veterinario, String diagnostico, String medicacion, String recomendaciones) {
        this.fechaCita = fechaCita;
        this.veterinario = veterinario;
        this.disgnostico = diagnostico;
        this.medicacion = medicacion;
        this.recomendaciones = recomendaciones;
    }

    @Override
    public String toString() {
        return "Fecha de cita: " + fechaCita + "\nVeterinario: " + veterinario + "\nDiagnostico: " + disgnostico + "\nMedicacion: " + medicacion + "\nRecomenciones: " + recomendaciones;
    }
}
