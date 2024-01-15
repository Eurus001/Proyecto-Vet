public class Solicitud {

    private Adoptante adoptante;
    private Mascota mascota;
    private boolean estado;

    public Solicitud(Adoptante adoptante, Mascota mascota) {
        this.adoptante = adoptante;
        this.mascota = mascota;
        this.estado = aceptacion();
    }

    boolean aceptacion(){
        return ((adoptante.getTamanoDom()/100) >= 100);
    }

    public Mascota datosMascota(){
        if (estado){
            return mascota;
        }else {
            return null;
        }
    }

}
