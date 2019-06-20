package obligatorio.entities.nodos;

import obligatorio.entities.Athlete;
import obligatorio.entities.NationalOlympicCommittee;

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
      int hashVal =  aux.hashCode();
      hashVal = hashVal + this.athlete.hashCode();
      return hashVal;
    }
}
