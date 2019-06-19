package obligatorio.entities;

public class Athlete {
    private String name;
    private long id;
    private SexType sex;
    private float height;
    private int age;

    public SexType getSex() {
        return sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

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

    public SexType isSex() {
        return sex;
    }

    public void setSex(SexType sex) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Athlete(long id, String name, SexType sex, int age, float height, float weight, Team team, NationalOlympicCommittee region) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.weight = weight;
        this.team = team;
        this.region = region;
        this.height = height;
        this.age = age;
    }
}
