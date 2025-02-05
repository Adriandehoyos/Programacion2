
public class Gato extends Mascotas{

private String color;
private String peloLargo;

public Gato(String nombre, double edad, String estado, String fechaDeNacimiento, String color, String peloLargo){

    this.color = color;
    this.peloLargo = peloLargo;
}

@Override
void muestra() {
    System.out.println("Gato - Nombre: " + nombre + ", Color: " + color);
}

@Override
void habla() {
    System.out.println("¡Miau!");
}

}//
