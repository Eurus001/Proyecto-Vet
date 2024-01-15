public class Persona {

    private String CI;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private int edad;


    public Persona(String CI, String nombre, String apellido, String telefono, String email, int edad) {
        this.CI = CI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void actualizarDatos(String nombre, String apellido, String telefono, String email, int edad){;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "CI: " + CI + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nTelefono: " + telefono + "\nE-mail: " + email + "\nEdad: " + edad;
    }

}
