package obligatorio.entities;

public enum SexType {
    FEMALE (1,"muejer") , MALE (2,"hombre");

    private int numero;
    private String tipo;

    private SexType (int numero, String tipo){
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
}
