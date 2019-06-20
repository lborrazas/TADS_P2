package obligatorio.entities;

import obligatorio.entities.enumerados.SeasonType;
import tad.LinkedList;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;
    private City city;
    private LinkedList<Event> events;
    private int nrodeF;
    private int nrodeM;

    public OlympicGame(String name, int year, SeasonType season, City city, LinkedList<Event> events) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.city = city;
        this.events = events;
        this.nrodeF = 0;
        this.nrodeM = 0;

    }

    public OlympicGame(String name, int year, SeasonType season, City city) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.city = city;
        this.events = new LinkedList<>();
        this.nrodeF = 0;
        this.nrodeM = 0;

    }

    public LinkedList<Event> getEvents() {
        return events;
    }

    public void setEvents(LinkedList<Event> events) {
        this.events = events;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SeasonType isSeason() {
        return season;
    }

    public int getNrodeF() {
        return nrodeF;
    }

    public void setNrodeF(int nrodeF) {
        this.nrodeF = nrodeF;
    }

    public int getNrodeM() {
        return nrodeM;
    }

    public void setNrodeM(int nrodeM) {
        this.nrodeM = nrodeM;
    }

    public SeasonType getSeason() {
        return season;
    }

    public void setSeason(SeasonType season) {
        this.season = season;
    }

    public boolean equals(Object obj) {
        OlympicGame aux = (OlympicGame) obj;
        return this.name.equals(aux.name);
    }

    public int hashCode() {
        String s = name;
        int hashVal = 7;
        for (int i = 0; i < s.length(); i = i + 2) {
            hashVal = hashVal * 31 + s.charAt(i);
        }
        return hashVal;
    }
}
