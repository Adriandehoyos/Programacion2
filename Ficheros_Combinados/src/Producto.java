public class Producto {

    private String nombre;
    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    
    public Producto(String nombre, String referencia, String descripcion, String tipo, int cantidad, double precio,
            int descuento, int iva, boolean aplicarDto) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }


    public Producto(String referencia, String nombre, String descripcion, String tipo) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getReferencia() {
        return referencia;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public int getDescuento() {
        return descuento;
    }


    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }


    public int getIva() {
        return iva;
    }


    public void setIva(int iva) {
        this.iva = iva;
    }


    public boolean isAplicarDto() {
        return aplicarDto;
    }


    public void setAplicarDto(boolean aplicarDto) {
        this.aplicarDto = aplicarDto;
    }


    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", referencia=" + referencia + ", descripcion=" + descripcion + ", tipo="
                + tipo + ", cantidad=" + cantidad + ", precio=" + precio + ", descuento=" + descuento + ", iva=" + iva
                + ", aplicarDto=" + aplicarDto + "]";
    }

    
    
    

}
