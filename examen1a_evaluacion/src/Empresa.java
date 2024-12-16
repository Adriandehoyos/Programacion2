
import java.time.LocalDate;

public class Empresa {


    private String nombreEmpresa;
    private String cif;
    private LocalDate fechaFundacion;
    private Trabajador [] trabajadores;
    private int nTraActuales;

    public Empresa(String nombreEmpresa, String cif, int maximoTrabajadores){
        this.nombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.fechaFundacion = LocalDate.now();
        this.trabajadores = new Trabajador[maximoTrabajadores];
        this.nTraActuales = 0;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public int getnTraActuales() {
        return nTraActuales;
    }

    //registrar trabajador
    public boolean meterTrabajador(Trabajador t1){
        boolean isadd = false;
        if(t1 != null){
            this.trabajadores[nTraActuales] = t1;
            this.nTraActuales++;
            isadd = true;
        }
        return isadd;
    }

    //eliminar trabajador de empresa
    public boolean sacarTrabajador(Trabajador t1){
        boolean isremoved = false;
        if(t1 != null){
            this.nTraActuales--;

        }

        return isremoved;
    }

    //info empresa
    public String mostrarInfoEmpresa(){
        String infoEmpresa = String.format("Empresa - NombreEmpresa: %s Cif: %s FechaFundacion: %s Trabajadores registrados: %s ",
        this.nombreEmpresa, this.cif, this.fechaFundacion, this.nTraActuales);
        return infoEmpresa;
    }

    //info trabajadores registrados en la empresa
    public String mostrarInfoTraActu(){
        String info = "";
        for(int i = 0; i < nTraActuales; i++){
        System.out.println(i + "." + trabajadores[i].mostrarInfoTrabajador());
        }
    return info;
    }

    public String mostrarTrabajadores(){
        String info = "";
        if(trabajadores != null){
            for (int i = 0; i < nTraActuales; i++) {
                System.out.println(i + "." + trabajadores[i].mostrarInfoTrabajador());
            }
        }
        return info;
    }






}//
