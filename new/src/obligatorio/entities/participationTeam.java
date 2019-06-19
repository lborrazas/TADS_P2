package obligatorio.entities;

public class participationTeam {
    private AthleteOlympicParticipation participation;

    public participationTeam(AthleteOlympicParticipation participation, Team team) {
        this.participation = participation;
    }

    public AthleteOlympicParticipation getParticipation() {
        return participation;
    }

    public void setParticipation(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }


    public participationTeam(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }
}
