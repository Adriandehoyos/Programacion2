
abstract class Mascotas {
protected String nombre;
protected int edad;
protected String estado;
protected String fechaNacimiento;

abstract void muestra();

public void cumpleaños(){
    System.out.println("¡Feliz Cumpleaños!");
}

public void morir(){
    System.out.println("Fallecido");
}
abstract void habla();

}// 
