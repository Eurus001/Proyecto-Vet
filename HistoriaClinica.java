import java.util.ArrayList;

public class HistoriaClinica {

    private ArrayList<String> enfermedades = new ArrayList<String>();
    private ArrayList<String> discapacidades = new ArrayList<String>();
    private boolean esterilizado;
    private ArrayList<CitaMedica> citasmedicas = new ArrayList<CitaMedica>();

    public HistoriaClinica(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public void getEnfermedades() {
        if (enfermedades.size() == 0){
            System.out.println("Este animal no tiene discapacidades");
        }else{
            for (int i = 0; i < enfermedades.size(); i++){
                System.out.println("\n"+ enfermedades.get(i));
            }
        }
    }

    public void addEnfermedad(String element) {
        enfermedades.addLast(element);
    }

    public void getDiscapacidades() {
        if (discapacidades.size() == 0){
            System.out.println("Este animal no tiene discapacidades");
        }else{
            for (int i = 0; i < discapacidades.size(); i++){
                System.out.println("\n"+ discapacidades.get(i));
            }
        }
    }

    public void addDiscapacidad(String element) {
        discapacidades.addLast(element);
    }

    public void addCitaMedica(Fecha fechaCita, String veterinario, String diagnostico, String medicacion, String recomendaciones) {
        citasmedicas.addLast(new CitaMedica(fechaCita, veterinario, diagnostico, medicacion, recomendaciones));
    }
}
