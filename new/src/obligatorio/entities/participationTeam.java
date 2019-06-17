package obligatorio.entities;

public class participationTeam {
    private AthleteOlympicParticipation participation;
    private Team team = participation.getAthlete().getTeam();

    public participationTeam(AthleteOlympicParticipation participation, Team team) {
        this.participation = participation;
        this.team = team;
    }

    public AthleteOlympicParticipation getParticipation() {
        return participation;
    }

    public void setParticipation(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
