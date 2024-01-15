import java.time.LocalDate;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        LocalDate fechaActual = LocalDate.now();
        this.dia = fechaActual.getDayOfMonth();
        this.mes = fechaActual.getMonthValue();
        this.anio = fechaActual.getYear();
    }

    public Fecha( int pDia, int pMes, int pAnio )
    {
        dia = pDia;
        mes = pMes;
        anio = pAnio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override

    public String toString( )
    {
        return dia + "/" + mes + "/" + anio;
    }

}
