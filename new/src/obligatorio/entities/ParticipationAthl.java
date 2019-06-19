package obligatorio.entities;

public class ParticipationAthl {
    private AthleteOlympicParticipation participation;
    private Athlete athlete ;

    public ParticipationAthl(AthleteOlympicParticipation participation, Athlete athlete) {
        this.participation = participation;
        this.athlete = athlete;
    }

    public AthleteOlympicParticipation getParticipation() {
        return participation;
    }

    public void setParticipation(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public ParticipationAthl(AthleteOlympicParticipation participation) {
        this.participation = participation;
        this.athlete = participation.getAthlete();
    }
}
