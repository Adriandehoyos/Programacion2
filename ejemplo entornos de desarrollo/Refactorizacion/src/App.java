
public class App {

private String nombre;
private String apellido;
private int años;

public App(String nombre, String apellido, int años) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.años = años;
}

public String getNombre() {
    return nombre;
}

public String getApellido() {
    return apellido;
}

public int getAños() {
    return años;
}

@Override
public String toString() {
    return "App [nombre=" + nombre + ", apellido=" + apellido + ", años=" + años + "]";
}





}
