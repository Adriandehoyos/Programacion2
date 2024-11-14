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
    elementosactuales = 0;
  }

  public String getIban(){
    return this.iban;
  }

  public String getTitular(){
    return this.titular;
  }

  




}
