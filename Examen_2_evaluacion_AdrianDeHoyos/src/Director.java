
import java.time.LocalDate;

public class Director extends Trabajador{

    private int telefono;
    private boolean reunido;
    private boolean fueraOfi;

    public Director(boolean fueraOfi, boolean reunido, int telefono, String dni, String nombre, String direccion, LocalDate fechaNacimiento, String correoE, double salario, Departamento dept, boolean trabajando) throws Exception {
        super(dni, nombre, direccion, fechaNacimiento, correoE, salario, dept, trabajando);
        this.fueraOfi = fueraOfi;
        this.reunido = reunido;
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public boolean isReunido() {
        return reunido;
    }

    public boolean isFueraOfi() {
        return fueraOfi;
    }

    @Override
    public String toString() {
        return "Director [Nombre= " + nombre + ", Telefono= "+ telefono + ", Esta Reunido= "+ reunido+ ", Esta en la Oficina= "+ fueraOfi+"]";
    }
    

}
