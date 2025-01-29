import java.time.LocalDateTime;

public class Gato extends Mascotas{

private String color;
private boolean peloLargo = false;

public Gato(String nombre, double edad, boolean estado, LocalDateTime fechaDeNacimiento, String color, boolean peloLargo){

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
