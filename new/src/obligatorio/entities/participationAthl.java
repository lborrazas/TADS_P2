package obligatorio.entities;

public class participationAthl {
    private AthleteOlympicParticipation participation;
    private Athlete athlete = participation.getAthlete();

    public participationAthl(AthleteOlympicParticipation participation, Athlete athlete) {
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
}
