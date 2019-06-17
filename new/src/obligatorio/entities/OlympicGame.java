package obligatorio.entities;

import java.util.LinkedList;

public class OlympicGame {
    private String name;
    private int year;
    private boolean season;
    private City city;
    private LinkedList<Event> events = new LinkedList<>();

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

    public boolean isSeason() {
        return season;
    }

    public void setSeason(boolean season) {
        this.season = season;
    }

    public OlympicGame(String name, int year, boolean season, City city, LinkedList<Event> events) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.city = city;
        this.events = events;
    }
}
