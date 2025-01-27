import java.time.LocalDateTime;

public class Gato extends Mascotas{

private String color;
private boolean peloLargo = false;

public Gato(String nombre, double edad, boolean estado, LocalDateTime fechaDeNacimiento, String color, boolean peloLargo){
    super(nombre, edad, estado, fechaDeNacimiento);

    this.color = color;
    this.peloLargo = peloLargo;
}

public String getColor() {
    return color;
}

public boolean isPeloLargo() {
    return peloLargo;
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gato{");
        sb.append("Nombre de la mascota= ").append(super.getNombre());
        sb.append(", Edad de la mascota= ").append(super.getEdad());
        sb.append(", ¿Esta vivo? ").append(super.isEstado());
        sb.append(", Fecha de nacimiento de la mascota= ").append(super.getFechaDeNacimiento());
        sb.append(", color=").append(color);
        sb.append(", peloLargo=").append(peloLargo);
        sb.append('}');
        return sb.toString();
    }


}//
