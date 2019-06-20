package obligatorio.entities;

import obligatorio.entities.enumerados.SexType;

import java.util.ArrayList;

public class Athlete {
    private int gCount;
    private int sCount;
    private int bCount;
    private int total;
    private String name;
    private long id;
    private SexType sex;
    private float height;
    private int age;
    private float weight;
    private Team team;
    private NationalOlympicCommittee region;
    private ArrayList<AthleteOlympicParticipation> athleteOlympicParticipations;

    public Athlete(long id, String name, SexType sex, int age, float height, float weight, Team team, NationalOlympicCommittee region) {

        this.name = name;
        this.id = id;
        this.sex = sex;
        this.weight = weight;
        this.team = team;
        this.region = region;

        this.athleteOlympicParticipations = new ArrayList<AthleteOlympicParticipation>();
        this.height = height;
        this.age = age;
        this.gCount = 0;
        this.sCount = 0;
        this.bCount = 0;
        this.total = 0;
    }


    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public NationalOlympicCommittee getRegion() {
        return region;
    }

    public void setRegion(NationalOlympicCommittee region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SexType isSex() {
        return sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addParticipation(AthleteOlympicParticipation olympicParticipation) {
        athleteOlympicParticipations.add(olympicParticipation);
    }

    public void addGcount() {
        this.gCount++;
        this.total++;
    }

    public void addScount() {
        this.sCount++;
        this.total++;
    }

    public void addBcount() {
        this.bCount++;
        this.total++;
    }

    public ArrayList<AthleteOlympicParticipation> getAthleteOlympicParticipations() {
        return athleteOlympicParticipations;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getgCount() {
        return gCount;
    }

    public int getsCount() {
        return sCount;
    }

    public int getbCount() {
        return bCount;
    }

    public int getTotal() {
        return total;
    }


    public int hashCode() {
        return (int)id;
    }


    public boolean equals(Object obj) {
       boolean bool = false;
       Athlete aux = (Athlete)obj;
       if (this.id == aux.getId()){
           bool = true;
       }
       return bool;
    }

    public void resetMedals(){
        this.sCount = 0;
        this.bCount = 0;
        this.gCount = 0;
        this.total =0;
    }
}
