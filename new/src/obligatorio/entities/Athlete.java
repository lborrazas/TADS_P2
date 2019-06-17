package obligatorio.entities;

public class Athlete {
    private String name;
    private long id;
    private boolean sex;
    private float weight;
    private Team team;
    private NationalOlympicCommittee region;

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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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
}
