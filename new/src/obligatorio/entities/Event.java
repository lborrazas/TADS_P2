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

    private boolean checked;

    public Event(String name, Sport sport) {
        this.name = name;
        this.sport = sport;
        this.checked = false;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean equals(Object obj) {
        boolean bool = false;
        Event aux = (Event) obj;
        if(this.name.equals(aux.name)){
            bool = true;
        }
        return bool;
    }
}
