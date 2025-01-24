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
        
    }

}//
