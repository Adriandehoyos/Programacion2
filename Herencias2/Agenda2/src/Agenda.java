public class Agenda {
    private Contacto[] contGuardados;
    private int nContactos;

    public Agenda(){
        this.contGuardados = new Contacto[100];
        this.nContactos = 0;
        
    }

    public boolean añadirContacto(Contacto c){
        if (nContactos >= 100){
            System.out.println("La Agenda esta completa");
            return false;
        }else{
            contGuardados[nContactos] = c;
            nContactos++;
            return true;
        }

    }

    public boolean eliminarContacto(String nombre){
        for (int i = 0; i < nContactos; i++) {
            if (contGuardados[i].getNombre().equals(nombre)) {
                contGuardados[i] = contGuardados[nContactos - 1];
                nContactos--;
                return true;
            }
        }
        return false;
    }

    public boolean existeContacto(String nombre){
        for (int i = 0; i < nContactos; i++) {
            if (contGuardados[i].getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void listarContactos() {
        if (nContactos == 0) {
            System.out.println("La agenda está vacía.");
        } else {
            for (int i = 0; i < nContactos; i++) {
                System.out.println((i + 1) + ". " + contGuardados[i].getNombre() + " - " + contGuardados[i].getTelefono());
            }
        }
    }

    public int buscaContacto(String nombre) {
        for (int i = 0; i < nContactos; i++) {
            if (contGuardados[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public Contacto getContacto(int indice) {
        return contGuardados[indice];
    }


}//
