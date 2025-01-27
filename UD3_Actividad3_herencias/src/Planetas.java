public class Planetas extends Astro{

    private double distanciaSol;
    private double  orbitaSol;
    private boolean tieneSatelites;

    public Planetas(double masaCuerpo,double diametroMedio, double periodoRotacion, double períodoTraslacion, double distanciaMedia, 
    double distanciaSol, double orbitaSol, boolean tieneSatelites){
        super(masaCuerpo, diametroMedio, periodoRotacion, períodoTraslacion, distanciaMedia);

        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.tieneSatelites = tieneSatelites; 
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public double getOrbitaSol() {
        return orbitaSol;
    }

    public boolean isTieneSatelites() {
        return tieneSatelites;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Planeta ");
        sb.append("Masa del Cuerpo:").append(super.getMasaCuerpo());
        sb.append(", Diametro Medio:").append(super.getDiametroMedio());
        sb.append(", Periodo de Rotacion:").append(super.getPeriodoRotacion());
        sb.append(", Periodo de Traslacion:").append(super.getPeríodoTraslacion());
        sb.append(", Distancia Media:").append(super.getDistanciaMedia());
        sb.append(", Distancia al Sol:").append(this.distanciaSol);
        sb.append(", Orbita al Sol:").append(this.orbitaSol);
        sb.append(", ¿Tiene satelites?:").append(this.tieneSatelites);
        return sb.toString();
    }

}//
