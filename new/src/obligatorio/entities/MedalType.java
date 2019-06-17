package obligatorio.entities;

public enum MedalType {
    GOLD("oro",1), SILVER("plata",2), BRONZE("bronce",3);

    private String tipo;
    private int puesto;

    private MedalType(String tipo, int puesto){
        this.tipo = tipo;
        this.puesto = puesto;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPuesto() {
        return puesto;
    }
}
