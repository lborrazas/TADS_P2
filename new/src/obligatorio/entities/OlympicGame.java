package obligatorio.entities;

import tad.LinkedList;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;
    private City city;
    private LinkedList<Event> events ;

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

    public void setSeason(SeasonType season) {
        this.season = season;
    }

    public OlympicGame(String name, int year, SeasonType season, City city, LinkedList<Event> events) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.city = city;
        this.events = events;
    }

    public OlympicGame(String name, int year, SeasonType season, City city) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.city = city;
        this.events = null;
    }


    public SeasonType getSeason() {
        return season;
    }

    public boolean equals(OlympicGame olympicGame) {
        if (olympicGame.getName().equals(this.name) ){
            return true;
        }
        return false;
    }
}
