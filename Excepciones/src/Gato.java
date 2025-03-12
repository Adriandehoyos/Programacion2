public class Gato {
    private String nombre;
    private int edad;
    public Gato(String nombre, int edad) throws Exception {
        setNombre(nombre);
        setEdad(edad);
    }
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setNombre(String nombre) throws Exception{
        if(nombre == null || nombre.length()< 3){
            throw new Exception("El nombre no es valido vuelva a introducirlo");
        }
        this.nombre = nombre;
    }

    public void setEdad(int edad) throws Exception{
        if(edad<= 0){
            throw new Exception("El gato no puede tener una edad negativa");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "El gato se llama "+nombre+" y tiene una edad de: "+edad + "Años";
    }

    
}
