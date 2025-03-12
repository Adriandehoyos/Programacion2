
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Empresa {
    Scanner reader = new Scanner(System.in);
    private String nombreEm;
    private String cif;
    private LocalDate fechaFundacion;
    LinkedList<Trabajador> tEmpresa = new LinkedList<>();
    
    

    public Empresa(String nombreEm, String cif) {
        this.nombreEm = nombreEm;
        this.cif = cif;
        this.fechaFundacion = LocalDate.now();
        this.tEmpresa = tEmpresa;
    }



    public boolean registrarTrabajador(Trabajador trabajador) throws TrabajadorYaRegistradoException{
        for (Trabajador t : tEmpresa) {
            if(trabajador.getDni().equals(t.getDni())){
                throw new TrabajadorYaRegistradoException("Ya existe un Trabajador registrado con el dni: " + trabajador.getDni() + ".");
            }
        }
        tEmpresa.add(trabajador);
        System.out.println("Asignale un Numero SS al trabajador");
        int nSS = reader.nextInt();
        try {
            trabajador.setNumeroSS(nSS);
        } catch (Exception e) {
            System.out.println("Hubo un Error: "+e.getMessage());
        }
        return true;
    }

    public boolean registrarGerente(GerenteDep gerente) throws TrabajadorYaRegistradoException{
        for (Trabajador g : tEmpresa) {
            if(gerente.getDni().equals(g.getDni())){
                throw new TrabajadorYaRegistradoException("Ya existe un Trabajador registrado con el dni en la empresa: " + gerente.getDni() + ".");
            }
        }
        tEmpresa.add(gerente);
        System.out.println("Asignale un Numero SS al trabajador");
        int nSS = reader.nextInt();
        try {
            gerente.setNumeroSS(nSS);
        } catch (Exception e) {
            System.out.println("Hubo un Error: "+e.getMessage());
        }
        return true;
    }

    public boolean registrarDirector(Director director) throws TrabajadorYaRegistradoException{
        for (Trabajador d : tEmpresa) {
            if(director.getDni().equals(d.getDni())){
                throw new TrabajadorYaRegistradoException("Ya existe un Trabajador registrado con el dni: " + director.getDni() + ".");
            }
        }
        tEmpresa.add(director);
        System.out.println("Asignale un Numero SS al trabajador");
        int nSS = reader.nextInt();
        try {
            director.setNumeroSS(nSS);
        } catch (Exception e) {
            System.out.println("Hubo un Error: "+e.getMessage());
        }
        return true;
    }

    public String eliminarTrabajador(String dni){
        for (Trabajador t : tEmpresa) {
            if (t.getDni() == dni) {
                tEmpresa.remove(t);
                return t.toString();
            }
        }
        return "No se ha encontrado el trabajador";
    }



    @Override
    public String toString() {
        return "Empresa [nombre de la Empresa= " + nombreEm + ", CIF= " + cif + ", fecha Fundacion= " + fechaFundacion +"]";
    }


    public String mostrarinfoTrabajadores() {
        Iterator<Trabajador> itera = tEmpresa.iterator();
        StringBuilder resultado = new StringBuilder();
        while (itera.hasNext()) {
            Trabajador cadaTrabajador = itera.next();
            resultado.append(cadaTrabajador.toString()).append("\n");
        }
        return resultado.toString();
    }

    public String reunirEmpresa(boolean trabajando){
        for (Trabajador t : tEmpresa) {
            if(t.isTrabajando()){
                System.out.println(t.toString());
            }
        }
        return "No hay trabajadores trabajando ahora mismo en la Empresa";
    }
}
