public class Contactos {

    private String nombre;
    private String telefono;

    public Contactos(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contactos{");
        sb.append("nombre= ").append(nombre);
        sb.append(", telefono= ").append(telefono);
        sb.append('}');
        return sb.toString();
    }
}//
