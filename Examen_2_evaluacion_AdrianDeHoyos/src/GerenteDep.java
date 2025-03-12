
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class GerenteDep extends Trabajador{
    Scanner reader = new Scanner(System.in);
    private int numTraDep;
    private int telefono;
    LinkedList<Trabajador> trabajadoresDep;
    
    public GerenteDep(String dni, String nombre, String direccion, LocalDate fechaNacimiento,
            String correoE, double salario, Departamento dept, boolean trabajando, int telefono) throws Exception {
        super(dni, nombre, direccion, fechaNacimiento, correoE, salario, dept, trabajando);
        this.numTraDep = numTraDep;
        this.telefono = telefono;
        this.trabajadoresDep = trabajadoresDep;
    }
    public int getNumTraDep() {
        return numTraDep;
    }
    public int getTelefono() {
        return telefono;
    }
    public LinkedList<Trabajador> getTrabajadoresDep() {
        return trabajadoresDep;
    }
    @Override
    public String toString() {
        return "GerenteDep [Nombre=" + nombre + ", Numero de Trabajadores del Departamento=" + numTraDep + ", telefono=" + telefono+ "]";
    }

    public void agregarTrAlDep(Trabajador tDep) {
        trabajadoresDep.add(tDep);
    }


    public void quitarTrAlDep(Trabajador tDep) {
        trabajadoresDep.remove(tDep);
    }

    // public void convocarReunionDepartamento(LocalDateTime fReunion){
    //     System.out.println("Cuando Quieres convocar la reunion: ");
    //     fReunion = reader.next;
    // }

    public void mostrarInfoDepartamento(){
        for (Trabajador tDep : trabajadoresDep) {
            System.out.println(trabajadoresDep.toString());
        }

    }
}
