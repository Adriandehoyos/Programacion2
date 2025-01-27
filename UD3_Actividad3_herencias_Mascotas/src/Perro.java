import java.time.LocalDateTime;

public class Perro extends Mascotas{

    private String raza;
    private boolean pulgas = false;

    public Perro(String nombre, int edad, String estado, String fechaDeNacimiento, String raza, boolean pulgas){
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaDeNacimiento;
        this.raza = raza;
        this.pulgas = pulgas;
    }

    public String getRaza() {
        return raza;
    }

    public boolean isPulgas() {
        return pulgas;
    }

}
