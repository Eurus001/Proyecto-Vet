public class Donacion {

    public enum FormaPago{
        EFECTIVO,
        TRANSFERENCIA,
        TARJETA;
    }

    private Fecha fechadonacion;
    private double montoDonacion;
    private FormaPago formaDePago;

    //para pruebas
    public Donacion(int dia, int mes, int anio, double montoDonacion, FormaPago formaDePago) {
        this.fechadonacion = new Fecha(dia, mes, anio);
        this.montoDonacion = montoDonacion;
        this.formaDePago = formaDePago;
    }

    public Donacion(double montoDonacion, FormaPago formaDePago) {
        this.fechadonacion = new Fecha();
        this.montoDonacion = montoDonacion;
        this.formaDePago = formaDePago;
    }

    public Fecha getFechadonacion() {
        return fechadonacion;
    }

    public double getMontoDonacion() {
        return montoDonacion;
    }



    public FormaPago getFormaDePago() {
        return formaDePago;
    }

    @Override

    public String toString(){
        return "Fecha de donacion: " + fechadonacion.toString() + "\nMonto donación: " + montoDonacion + "\nForma de pago: " + formaDePago;
    }

}
