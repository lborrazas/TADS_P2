package obligatorio.entities;

public class AthleteN1 {
    private Athlete athlete;
    private NationalOlympicCommittee noc = athlete.getRegion();

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public NationalOlympicCommittee getNoc() {
        return noc;
    }

    public void setNoc(NationalOlympicCommittee noc) {
        this.noc = noc;
    }

    public AthleteN1(Athlete athlete, NationalOlympicCommittee noc) {
        this.athlete = athlete;
        this.noc = noc;
    }
}
