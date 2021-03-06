package obligatorio.entities;

import obligatorio.entities.enumerados.MedalType;

public class AthleteOlympicParticipation {
    private MedalType medal;
    private Event event;
    private OlympicGame olympicGame;
    private Athlete athlete;
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

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

    public AthleteOlympicParticipation(MedalType medal, Event event, OlympicGame olympicGame, Athlete athlete, Team team) {
        this.medal = medal;
        this.event = event;
        this.olympicGame = olympicGame;
        this.athlete = athlete;
        this.team = team;
    }


    public boolean equals(Object obj) {
        boolean bool = false;
        AthleteOlympicParticipation aux = (AthleteOlympicParticipation) obj;
        if(this.athlete.equals(aux.athlete)){
            if (this.event.equals(aux.event)){
                if(this.olympicGame.equals(aux.olympicGame)){
                    bool = true;
                }
            }
        }
        return bool;
    }
}
