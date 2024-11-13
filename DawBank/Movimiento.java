
import java.time.LocalDateTime;

public class Movimiento {

    private static int contador = 0;

    private int id;
    private String fecha;
    private boolean tipo;
    private double cantidad;

    //constructores
    public Movimiento(boolean tipo, double cantidad){
        this.id = contador;
        contador++;

        this.fecha = LocalDateTime.now().toString();
        this.tipo = tipo;
        this.cantidad = cantidad; 
    }

    public int getId(){
        return this.id;
    }

    public String getFecha(){
        return this.fecha;
    }

    public boolean getTipo(){
        return this.tipo;
    }

    public double getCantidad(){
        return this.cantidad;
    }

    public String mostrarInfoMovimiento(){

        String mostrar = String.format("movimiento - Id: %s , Fecha: %s , Tipo: %s , Cantidad: %s" , this.id , this.fecha , this.tipo , this.cantidad);
        return mostrar;

    }












}
