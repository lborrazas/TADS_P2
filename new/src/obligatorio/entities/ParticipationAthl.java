package obligatorio.entities;

public class ParticipationAthl {
    private AthleteOlympicParticipation participation;

    public ParticipationAthl(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }

    public AthleteOlympicParticipation getParticipation() {
        return participation;
    }

    public void setParticipation(AthleteOlympicParticipation participation) {
        this.participation = participation;
    }

    public int hashCode() {
        return this.participation.getAthlete().hashCode();
    }


    public boolean equals(Object obj) {
        ParticipationAthl aux = (ParticipationAthl)obj;
        return this.participation.equals(aux.participation);
    }
}
