package obligatorio.entities;

public class AthleteNRegion {
    private Athlete athlete;


    public AthleteNRegion(Athlete athlete) {
        this.athlete = athlete;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public int hashCode() {
      NationalOlympicCommittee aux = this.athlete.getRegion();
      return aux.hashCode();
    }
}
