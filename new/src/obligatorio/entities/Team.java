package obligatorio.entities;

public class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int hashCode() {
        int hashVal = 0;
        for( int i = 0; i < name.length( ); i++ )
            hashVal = 37 * hashVal + name.charAt( i );
        return hashVal;
    }

    public boolean equals(Object obj) {
        Team team = (Team)obj;
        return this.name.equals(team.name);
    }

    private int medals;
    private int competidores;
    private float efectividad;

    public int getMedals() {
        return medals;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }

    public int getCompetidores() {
        return competidores;
    }

    public void setCompetidores(int competidores) {
        this.competidores = competidores;
    }

    public float getEfectividad() {
        return efectividad;
    }

    public void setEfectividad(float efectividad) {
        this.efectividad = efectividad;
    }
}
