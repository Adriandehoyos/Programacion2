public class inventario {
    private Mascotas [] animales;
    private int nAnimales;
    private int nMaxAnimales = 50;

    public inventario() {
        animales = new Mascotas[nMaxAnimales];
        nAnimales = 0;
    }
    
    public void mostrarListaAnimales() {
        for (int i = 0; i < nAnimales; i++) {
            animales[i].muestra();
        }
    }
    
    public void mostrarAnimal(int indice) {
        if (indice >= 0 && indice < nAnimales) {
            animales[indice].muestra();
        } else {
            System.out.println("No valido");
        }
    }
    
    public void mostrarTodosLosDatos() {
        for (int i = 0; i < nAnimales; i++) {
            System.out.println("\nAnimal " + (i+1) + ":");
            animales[i].muestra();
            System.out.println("Edad: " + animales[i].edad);
            System.out.println("Estado: " + animales[i].estado);
            System.out.println("Fecha de nacimiento: " + animales[i].fechaNacimiento);
        }
    }
    
    public void insertarAnimal(Mascotas animal) {
        if (nAnimales < nMaxAnimales) {
            animales[nAnimales] = animal;
            nAnimales++;
        } else {
            System.out.println("El inventario está lleno");
        }
    }
    
    public void eliminarAnimal(int indice) {
        if (indice >= 0 && indice < nAnimales) {
            for (int i = indice; i < nAnimales - 1; i++) {
                animales[i] = animales[i + 1];
            }
            animales[nAnimales - 1] = null;
            nAnimales--;
        } else {
            System.out.println("No valido");
        }
    }
    
    public void vaciarInventario() {
        for (int i = 0; i < nAnimales; i++) {
            animales[i] = null;
        }
        nAnimales = 0;
    }

}//
