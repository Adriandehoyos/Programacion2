
public class Perro extends Mascotas{

    private String raza;
    private String pulgas;

    public Perro(String nombre, int edad, String estado, String fechaDeNacimiento, String raza, String pulgas){
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaDeNacimiento;
        this.raza = raza;
        this.pulgas = pulgas;
    }

    @Override
    void muestra() {
        System.out.println("Perro - Nombre: " + nombre + ", Raza: " + raza);
    }
    
    @Override
    void habla() {
        System.out.println("¡Guau!");
    }

}//
