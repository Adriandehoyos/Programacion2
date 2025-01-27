public class Satelites extends Astro{

    private double distanciaPlaneta;
    private double orbitaPlanetaria;
    private String planetaPertenece;

    public Satelites(double masaCuerpo, double diametroMedio, double periodoRotacion, double períodoTraslacion, double distanciaMedia, double distanciaPlaneta, double orbitaPlanetaria, String planetaPertenece){

        super(masaCuerpo, diametroMedio, periodoRotacion, períodoTraslacion, distanciaMedia);

        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaPertenece = planetaPertenece;
    }

    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public double getOrbitaPlanetaria() {
        return orbitaPlanetaria;
    }

    public String getPlanetaPertenece() {
        return planetaPertenece;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Satelite ");
        sb.append("Masa del Cuerpo:").append(super.getMasaCuerpo());
        sb.append(", Diametro Medio:").append(super.getDiametroMedio());
        sb.append(", Periodo de Rotacion:").append(super.getPeriodoRotacion());
        sb.append(", Periodo de Traslacion:").append(super.getPeríodoTraslacion());
        sb.append(", Distancia Media:").append(super.getDistanciaMedia());
        sb.append(", Distancia al Planeta:").append(this.distanciaPlaneta);
        sb.append(", Orbita Planetaria:").append(this.orbitaPlanetaria);
        sb.append(", Planeta al que Pertenece:").append(this.planetaPertenece);
        return sb.toString();
    }

}//
