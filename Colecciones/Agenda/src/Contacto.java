import java.util.regex.Pattern;

public class Contacto {

    
    private String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        if (validarNombre(nombre)) this.nombre = nombre;
        else this.nombre = "";
        if (validarTelefono(telefono)) this.telefono = telefono;
        else this.telefono = "";
        if (validarCorreo(correo)) this.correo = correo;
        else this.correo = "";
    }

    private static boolean validarNombre(String nombre) {
        return Pattern.matches("[A-Z][a-zA-Z]*", nombre);
    }

    private static boolean validarTelefono(String telefono) {
        return Pattern.matches("[6,7,9][0-9]{8}", telefono);
    }

    private static boolean validarCorreo(String correo) {
        return Pattern.matches("[a-zA-Z0-9_.-]+@[a-z]+\\.[a-z]{2,4}", correo);
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    public void setTelefono(String telefono) {
        if (validarTelefono(telefono)) this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        if (validarCorreo(correo)) this.correo = correo;
    }
}//
