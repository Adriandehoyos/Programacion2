public class Astro {

    private double masaCuerpo;
    private double diametroMedio;
    private double  periodoRotacion;
    private double  períodoTraslacion;
    private double distanciaMedia;
    

    public Astro(double masaCuerpo,double diametroMedio, double periodoRotacion, double períodoTraslacion, double distanciaMedia){
        this.masaCuerpo = masaCuerpo;
        this.diametroMedio = diametroMedio;
        this.periodoRotacion = periodoRotacion;
        this.períodoTraslacion = períodoTraslacion;
        this.distanciaMedia = distanciaMedia;
    }


    public double getMasaCuerpo() {
        return masaCuerpo;
    }


    public double getDiametroMedio() {
        return diametroMedio;
    }


    public double getPeriodoRotacion() {
        return periodoRotacion;
    }


    public double getPeríodoTraslacion() {
        return períodoTraslacion;
    }


    public double getDistanciaMedia() {
        return distanciaMedia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Astro ");
        sb.append("Masa del cuerpo:").append(masaCuerpo);
        sb.append(", Diametro Medio:").append(diametroMedio);
        sb.append(", Periodo de rotacion:").append(periodoRotacion);
        sb.append(", Periodo de translacion:").append(períodoTraslacion);
        sb.append(", Distancia Media:").append(distanciaMedia);
        
        return sb.toString();
}


}//
