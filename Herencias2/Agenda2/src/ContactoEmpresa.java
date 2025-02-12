public class ContactoEmpresa extends Contacto {
    private String paginaWeb;

    public ContactoEmpresa(String nombre, String telefono, String paginaWeb) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactoEmpresa: ");
        sb.append("Nombre: ").append(getNombre());
        sb.append(", Telefono: ").append(getTelefono());
        sb.append(", Pagina Web: ").append(paginaWeb);
        sb.append('.');
        return sb.toString();
    }

}
