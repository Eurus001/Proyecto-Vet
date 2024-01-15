import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Adoptante> adoptantes = new ArrayList<Adoptante>();
        Scanner sc = new Scanner(System.in);
        int opc;

        while(true) {
            System.out.println("Ingrese una opcion");
            System.out.println("1. Ingresar datos de aspirante de mascota");
            System.out.println("2. Modificar datos de adoptante de mascota");
            System.out.println("3. Eliminar dueño de mascota");
            System.out.println("4. Obtener datos de dueño");
            System.out.println("5. Ingresar donacion");
            System.out.println("6. Consultar Donaciones (por metodo de pago)");
            System.out.println("7. Consultar donaciones (por fecha)");
            System.out.println("8. Consultar donaciones (por monto)");
            System.out.println("9. Ver todas las donaciones");
            System.out.println("10. Eliminar donacion");
            System.out.println("11. Salir");

            opc = Integer.parseInt(sc.nextLine());

            switch (opc){
                case 1:
                    System.out.println("Ingrese CI:");
                    String CI = sc.nextLine();
                    System.out.println("Ingrese nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese apellido:");
                    String apellido = sc.nextLine();
                    System.out.println("Ingrese telefono:");
                    String telefono = sc.nextLine();
                    System.out.println("Ingrese email:");
                    String email = sc.nextLine();
                    System.out.println("Ingrese edad:");
                    int edad = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese domicilio:");
                    String domicilio = sc.nextLine();
                    System.out.println("Ingrese tamaño del domicilio:");
                    double tamanoDom = Double.parseDouble(sc.nextLine());

                    Adoptante nuevoAdoptante = new Adoptante(CI, nombre, apellido, telefono, email, edad, domicilio, tamanoDom);
                    adoptantes.add(nuevoAdoptante);
                    break;

                case 2:
                    System.out.println("Ingrese el CI del adoptante a modificar:");
                    String ciModificar = sc.nextLine();
                    Adoptante adoptanteAModificar = buscarAdoptantesPorCedula(adoptantes, ciModificar);
                    if (adoptanteAModificar != null) {
                        System.out.println("Ingrese CI:");
                        CI = sc.nextLine();
                        System.out.println("Ingrese nombre:");
                        nombre = sc.nextLine();
                        System.out.println("Ingrese apellido:");
                        apellido = sc.nextLine();
                        System.out.println("Ingrese telefono:");
                        telefono = sc.nextLine();
                        System.out.println("Ingrese email:");
                        email = sc.nextLine();
                        System.out.println("Ingrese edad:");
                        edad = Integer.parseInt(sc.nextLine());
                        System.out.println("Ingrese domicilio:");
                        domicilio = sc.nextLine();
                        System.out.println("Ingrese tamaño del domicilio:");
                        tamanoDom = Double.parseDouble(sc.nextLine());

                        adoptanteAModificar.actualizarDatos(nombre, apellido, telefono, email, edad, domicilio, tamanoDom);
                    } else {
                        System.out.println("Adoptante no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el CI del adoptante a eliminar:");
                    String ciEliminar = sc.nextLine();
                    Adoptante adoptanteAEliminar = buscarAdoptantesPorCedula(adoptantes, ciEliminar);
                    if (adoptanteAEliminar != null) {
                        adoptantes.remove(adoptanteAEliminar);
                    } else {
                        System.out.println("Adoptante no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el CI del adoptante cuyos datos desea obtener:");
                    String ciBuscar = sc.nextLine();
                    Adoptante adoptanteABuscar = buscarAdoptantesPorCedula(adoptantes, ciBuscar);
                    if (adoptanteABuscar != null) {
                        System.out.println("Datos del Adoptante:");
                        System.out.println(adoptanteABuscar.toString());
                    } else {
                        System.out.println("Adoptante no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese el CI del adoptante que hace la donación:");
                    String ciDonacion = sc.nextLine();
                    Adoptante adoptanteDonacion = buscarAdoptantesPorCedula(adoptantes, ciDonacion);
                    System.out.println("Elija si desea ingresar fecha (para pruebas profe no alcance a quemar datos) o usar fecha actual (0 o 1)");
                    int opcF = Integer.parseInt(sc.next());
                    if (opcF == 0){
                        if (adoptanteDonacion != null) {
                            System.out.println("Ingrese el día de la donación:");
                            int dia= Integer.parseInt(sc.nextLine());
                            System.out.println("Ingrese el mes de la donación:");
                            int mes= Integer.parseInt(sc.nextLine());
                            System.out.println("Ingrese el año de la donación:");
                            int anio= Integer.parseInt(sc.nextLine());
                            System.out.println("Ingrese monto de la donación:");
                            double monto = Double.parseDouble(sc.nextLine());
                            System.out.println("Seleccione la forma de pago (0-efectivo, 1-transferencia, 2-tarjeta):");
                            for (Donacion.FormaPago fp : Donacion.FormaPago.values()) {
                                System.out.println(fp.ordinal() + ". " + fp);
                            }
                            int opcionPago = Integer.parseInt(sc.nextLine());
                            Donacion.FormaPago formaDePago = Donacion.FormaPago.values()[opcionPago];
                            adoptanteDonacion.addDonacion(dia, mes, anio, monto, formaDePago);
                        } else {
                            System.out.println("Adoptante no encontrado.");
                        }
                    }else{
                        if (adoptanteDonacion != null) {
                            System.out.println("Ingrese monto de la donación:");
                            double monto = Double.parseDouble(sc.nextLine());
                            System.out.println("Seleccione la forma de pago (0-efectivo, 1-transferencia, 2-tarjeta):");
                            for (Donacion.FormaPago fp : Donacion.FormaPago.values()) {
                                System.out.println(fp.ordinal() + ". " + fp);
                            }
                            int opcionPago = Integer.parseInt(sc.nextLine());
                            Donacion.FormaPago formaDePago = Donacion.FormaPago.values()[opcionPago];
                            adoptanteDonacion.addDonacion(monto, formaDePago);
                        } else {
                            System.out.println("Adoptante no encontrado.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Ingrese el CI del adoptante para calcular el total donado:");
                    String ciTotalDonado = sc.nextLine();
                    Adoptante adoptanteTotalDonado = buscarAdoptantesPorCedula(adoptantes, ciTotalDonado);
                    if (adoptanteTotalDonado != null) {
                        System.out.println("Seleccione el método de pago para calcular el total:");
                        System.out.println("0. Efectivo");
                        System.out.println("1. Transferencia");
                        System.out.println("2. Tarjeta");
                        System.out.println("3. Total de todas las donaciones");
                        int metodoPago = Integer.parseInt(sc.nextLine());

                        double total = adoptanteTotalDonado.totalDonado(metodoPago);
                        if (total != -1) {
                            System.out.println("El total donado es: " + total);
                        } else {
                            System.out.println("Método de pago inválido.");
                        }
                    } else {
                        System.out.println("Adoptante no encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("Ingrese el CI del adoptante para calcular el total donado en una fecha específica:");
                    String ciBusquedaFecha = sc.nextLine();
                    Adoptante adoptanteBusquedaFecha = buscarAdoptantesPorCedula(adoptantes, ciBusquedaFecha);
                    if (adoptanteBusquedaFecha != null) {
                        System.out.println("Ingrese el día de la donación:");
                        int diaBusqueda = Integer.parseInt(sc.nextLine());
                        System.out.println("Ingrese el mes de la donación:");
                        int mesBusqueda = Integer.parseInt(sc.nextLine());
                        System.out.println("Ingrese el año de la donación:");
                        int anioBusqueda = Integer.parseInt(sc.nextLine());

                        double totalFecha = adoptanteBusquedaFecha.totalDonacionesPorFecha(diaBusqueda, mesBusqueda, anioBusqueda);
                        System.out.println("El total donado en la fecha " + diaBusqueda + "/" + mesBusqueda + "/" + anioBusqueda + " es: " + totalFecha);
                    } else {
                        System.out.println("Adoptante no encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("Ingrese el CI del adoptante para calcular el total donado de un monto específico:");
                    String ciBusquedaMonto = sc.nextLine();
                    Adoptante adoptanteBusquedaMonto = buscarAdoptantesPorCedula(adoptantes, ciBusquedaMonto);
                    if (adoptanteBusquedaMonto != null) {
                        System.out.println("Ingrese el monto de donación a buscar:");
                        double montoBusqueda = Double.parseDouble(sc.nextLine());

                        double totalMonto = adoptanteBusquedaMonto.totalDonacionesPorMontoExacto(montoBusqueda);
                        System.out.println("El total donado en donaciones de monto exacto " + montoBusqueda + " es: " + totalMonto);
                    } else {
                        System.out.println("Adoptante no encontrado.");
                    }
                    break;

                case 9:
                    System.out.println("Ingrese el CI del adoptante para ver sus donaciones:");
                    String ciDonaciones = sc.nextLine();
                    Adoptante adoptanteDonaciones = buscarAdoptantesPorCedula(adoptantes, ciDonaciones);
                    if (adoptanteDonaciones != null) {
                        ArrayList<Donacion> listaDonaciones = adoptanteDonaciones.getDonaciones();
                        if (!listaDonaciones.isEmpty()) {
                            System.out.println("Donaciones del Adoptante:");
                            for (Donacion donacion : listaDonaciones) {
                                System.out.println(donacion);
                            }
                        } else {
                            System.out.println("Este adoptante no tiene donaciones registradas.");
                        }
                    } else {
                        System.out.println("Adoptante no encontrado.");
                    }
                    break;

                case 10:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    private static Adoptante buscarAdoptantesPorCedula(ArrayList<Adoptante> adoptantes, String cedula) {
        for (Adoptante adoptante : adoptantes) {
            if (adoptante.getCI().equals(cedula)) {
                return adoptante;
            }
        }
        return null;
    }
}
