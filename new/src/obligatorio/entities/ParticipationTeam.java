package obligatorio.entities;

public class ParticipationTeam {
    private AthleteOlympicParticipation participation;

    public ParticipationTeam(AthleteOlympicParticipation participation, Team team) {
        this.participation = participation;
    }

    public AthleteOlympicParticipation getParticipation() {
        return participation;
    }

    public void setParticipation(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }


    public ParticipationTeam(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }
}