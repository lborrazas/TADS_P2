package obligatorio.entities;

public class AthleteOlympicParticipation {
    private MedalType medal;
    private Event event;
    private OlympicGame olympicGame;
    private Athlete athlete;

    public MedalType getMedal() {
        return medal;
    }

    public void setMedal(MedalType medal) {
        this.medal = medal;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public OlympicGame getOlympicGame() {
        return olympicGame;
    }

    public void setOlympicGame(OlympicGame olympicGame) {
        this.olympicGame = olympicGame;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public AthleteOlympicParticipation(MedalType medal, Event event, OlympicGame olympicGame, Athlete athlete) {
        this.medal = medal;
        this.event = event;
        this.olympicGame = olympicGame;
        this.athlete = athlete;
    }
}
