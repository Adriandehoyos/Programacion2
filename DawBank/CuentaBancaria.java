public class CuentaBancaria {

  private String iban;
  private String titular;
  private double saldo;
  //coleccion de movimientos
  private Movimiento [] movimientos;
  private int elementosactuales;


  public CuentaBancaria(String iban, String titular){

    this.iban = iban;
    this.titular = titular;
    this.saldo = 0;
    this.movimientos = new Movimiento[100];
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
          this.saldo = this.saldo + m1.getCantidad();
          System.out.println("Operacion realizada");
          isadd = true;
      }
      if (m1.getCantidad()>3000) {
        System.out.println("Notificar a hacienda");
      }
    }
    return isadd;
  }

  //retirada
  public boolean retirada(Movimiento m1){
    boolean isremoved = false;
    if(m1 != null) {
      if(m1.getCantidad() <= 0){
        System.out.println("Cantidad no valida de retirada");
      }
      
      if(this.saldo - m1.getCantidad()<= -50){
        System.err.println("Cantidad no valida supera los -50€");
      }else{
        this.movimientos[elementosactuales] = m1;
        this.elementosactuales++;
        this.saldo = this.saldo - m1.getCantidad();
        System.out.println("Operacion realizada");
        isremoved = true;
      }
    }

    return isremoved;
  }

    public String mostrarMovimiento(){
      if(elementosactuales==0){
          System.out.println("No existen movimientos.");
      }
      String infomovimiento = "";
      for (int i = 0; i < elementosactuales; i++) {
          infomovimiento += movimientos[i].mostrarInfoMovimiento();
      }
      return infomovimiento;
  }

}
