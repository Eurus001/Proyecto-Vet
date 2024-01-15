import java.util.ArrayList;


public class Adoptante extends Persona{

    private String domicilio;
    private double tamanoDom;
    private ArrayList<Donacion> donaciones;
    private ArrayList<Solicitud> solicitudes;

    public Adoptante(String CI, String nombre, String apellido, String telefono, String email, int edad, String domicilio, double tamanoDom) {
        super(CI, nombre, apellido, telefono, email, edad);
        this.domicilio = domicilio;
        this.tamanoDom = tamanoDom;
        donaciones = new ArrayList<Donacion>();
        solicitudes = new ArrayList<Solicitud>();
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getTamanoDom() {
        return tamanoDom;
    }

    public void setTamanoDom(double tamanoDom) {
        this.tamanoDom = tamanoDom;
    }

    public void addDonacion(int dia, int mes, int anio, double montoDonacion, Donacion.FormaPago formaDePago) {
        donaciones.addLast(new Donacion(dia, mes, anio, montoDonacion, formaDePago));
    }
    public void addDonacion(double montoDonacion, Donacion.FormaPago formaDePago) {
        donaciones.addLast(new Donacion(montoDonacion, formaDePago));
    }

    public ArrayList<Donacion> getDonaciones() {
        return donaciones;
    }

    public double totalDonado(int opc){
        double total = 0;
        switch (opc){
            case 0:
                for (Donacion donacion : donaciones) {
                    if (donacion.getFormaDePago() == Donacion.FormaPago.EFECTIVO) {
                        total += donacion.getMontoDonacion();
                    }
                }
                break;

            case 1:
                for (Donacion donacion : donaciones) {
                    if (donacion.getFormaDePago() == Donacion.FormaPago.TRANSFERENCIA) {
                        total += donacion.getMontoDonacion();
                    }
                }
                break;

            case 2:
                for (Donacion donacion : donaciones) {
                    if (donacion.getFormaDePago() == Donacion.FormaPago.TARJETA) {
                        total += donacion.getMontoDonacion();
                    }
                }
                break;

            case 3:
                for (Donacion donacion : donaciones) {
                    total += donacion.getMontoDonacion();
                }
                break;

            default:
                return -1;
        }
        return total;
    }

    public double totalDonacionesPorFecha(int dia, int mes, int anio) {
        double total = 0;
        for (Donacion donacion : donaciones) {
            Fecha fechaDonacion = donacion.getFechadonacion();
            if (fechaDonacion.getDia() == dia && fechaDonacion.getMes() == mes && fechaDonacion.getAnio() == anio) {
                total += donacion.getMontoDonacion();
            }
        }
        return total;
    }

    public double totalDonacionesPorMontoExacto(double montoBuscado) {
        double total = 0;
        for (Donacion donacion : donaciones) {
            if (donacion.getMontoDonacion() == montoBuscado) {
                total += donacion.getMontoDonacion();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDomicilio: " + domicilio + "\nTamaño del domicilio: " + tamanoDom;
    }

    public void actualizarDatos(String nombre, String apellido, String telefono, String email, int edad, String domicilio, double tamanoDom) {
        super.actualizarDatos(nombre, apellido, telefono, email, edad);
        this.domicilio = domicilio;
        this.tamanoDom = tamanoDom;
    }
}
