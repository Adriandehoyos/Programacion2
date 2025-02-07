public class Agenda {

    private Contactos[] contGuardados;
    private int nContactos;

    public Agenda(){
        this.contGuardados = new Contactos[100];
        this.nContactos = 0;
        
    }

    public boolean añadirContacto(Contactos contacto){
        if (nContactos >= 100){
            System.out.println("La Agenda esta completa");
            return false;
        }else{
            contGuardados[nContactos] = contacto;
            nContactos++;
            return true;
        }

    }

}
