package obligatorio.entities;

public class ParticipationOlympicGame {
    private AthleteOlympicParticipation participation;

    public ParticipationOlympicGame(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }

    public AthleteOlympicParticipation getParticipation() {
        return participation;
    }

    public void setParticipation(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }


    public int hashCode() {
       return this.participation.getOlympicGame().hashCode();
    }
}
