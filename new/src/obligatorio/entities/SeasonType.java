package obligatorio.entities;

public enum SeasonType {
    SUMMER(1,"verano"),WINTER(2,"invierno");

    private int Event;
    private String tipo;

    private SeasonType(int Event, String tipo){
        this.Event = Event;
        this.tipo = tipo;
    }

    public int getEvent() {
        return Event;
    }

    public String getTipo() {
        return tipo;
    }
}
