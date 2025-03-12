import java.time.LocalDate;

public class Trabajador extends Persona{

    private int numeroSS;
    private String correoE;
    private double salario;
    private Departamento dept;
    private boolean trabajando;


    public Trabajador(String dni, String nombre, String direccion, LocalDate fechaNacimiento,
            String correoE, double salario, Departamento dept, boolean trabajando) throws Exception{
        super(dni, nombre, direccion, fechaNacimiento);
        setNumeroSS(numeroSS);
        this.correoE = correoE;
        this.salario = salario;
        this.dept = dept;
        this.trabajando = false;
    }


    public int getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(int numeroSS) throws Exception{
        if(numeroSS != 10){
            throw new Exception("El numero SS no tiene los digitos requeridos");
        }
        this.numeroSS = numeroSS;
    }

    public String getCorreoE() {
        return correoE;
    }


    public double getSalario() {
        return salario;
    }


    public Departamento getDept() {
        return dept;
    }


    public boolean isTrabajando() {
        return trabajando;
    }


    public void setTrabajando(boolean trabajando) {
        this.trabajando = trabajando;
    }


    @Override
    public String toString() {
        return "Trabajador [numeroSS=" + numeroSS + ", correoE=" + correoE + ", nombre=" + nombre + ", salario="
                + salario + ", dept=" + dept + ", trabajando=" + trabajando + "]";
    }

    

}
