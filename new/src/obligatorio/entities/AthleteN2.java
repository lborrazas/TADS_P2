package obligatorio.entities;

public class AthleteN2 {
    private Athlete athlete;
    private Team team = athlete.getTeam();

    public AthleteN2(Athlete athlete, Team team) {
        this.athlete = athlete;
        this.team = team;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
