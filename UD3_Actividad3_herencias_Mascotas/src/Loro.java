public class Loro extends Aves{

private String origen;
private Boolean habla;

public Loro (String nombre, int edad, String estado, String fechaNacimiento, String pico, String vuela, String origen, Boolean habla){
    this.nombre = nombre;
    this.edad = edad;
    this.estado = estado;
    this.fechaNacimiento = fechaNacimiento;
    this.pico = pico;
    this.vuela = vuela;
    this.origen = origen;
    this.habla = habla;
}

@Override
void muestra() {
    System.out.println("Loro - Nombre: " + nombre + ", Origen: " + origen);
}

@Override
    void volar() {
        System.out.println("El loro está volando");
    }

@Override
    void habla() {
        System.out.println("Pio, Pio, Tio");
    }

}//
