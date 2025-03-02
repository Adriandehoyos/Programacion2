import java.util.LinkedList;

public class Agenda {
    private LinkedList<Contacto> contactos;

    public Agenda() {
        contactos = new LinkedList<>();
    }

    public boolean anadeContacto(String nombre, String telefono, String correo) {
        if (nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty()) return false;
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre)) return false;
        }
        contactos.add(new Contacto(nombre, telefono, correo));
        return true;
    }

    public Contacto buscaContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre)) return c;
        }
        return null;
    }

    public boolean eliminaContacto(String nombre) {
        return contactos.removeIf(c -> c.getNombre().equals(nombre));
    }

    public LinkedList<Contacto> getContactos() {
        return new LinkedList<>(contactos);
    }

    public int numeroContactos() {
        return contactos.size();
    }
}//
