package obligatorio.entities;

public class Event {
    private String name;
    private Sport sport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Event(String name, Sport sport) {
        this.name = name;
        this.sport = sport;
    }
}
