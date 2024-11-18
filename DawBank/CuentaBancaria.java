public class CuentaBancaria {

  private String iban;
  private String titular;
  private double saldo;
  //coleccion de movimientos
  private Movimiento [] movimientos;
  private int elementosactuales;


  public CuentaBancaria(String iban, String titular, int nmovimientos){

    this.iban = iban;
    this.titular = titular;
    this.saldo = 0;
    this.movimientos = new Movimiento[nmovimientos];
    this.elementosactuales = 0;
  }

  public String getIban(){
    return this.iban;
  }

  public String getTitular(){
    return this.titular;
  }

  public double getSaldo(){
    return this.saldo;
  }

  //ingresar
  public boolean ingresar(Movimiento m1){
    boolean isadd = false;
    if (m1 != null) {
      if(m1.getCantidad() <= 0){
        System.out.println("Cantidad no valida para ingresar");
      } else{
          this.movimientos[elementosactuales] = m1;
          this.elementosactuales++;
          isadd = true;
      }
    }
    return isadd;
  }

  //retirada
  public boolean retirada(Movimiento m1){
    boolean isremoved = false;
    if(m1 != null) {
      if(m1.getCantidad() >= 0){
        System.out.println("Cantidad no valida de retirada");
      }else{

      }


    }


  }



}
