package obligatorio.entities.nodos;

import obligatorio.entities.Athlete;
import obligatorio.entities.Team;

public class AthleteNTeam {
    private Athlete athlete;


    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public AthleteNTeam(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public int hashCode() {
      Team aux = this.athlete.getTeam();
      return aux.hashCode();
    }
}

