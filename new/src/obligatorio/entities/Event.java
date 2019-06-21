package obligatorio.entities;

public class Event {
    private String name;
    private Sport sport;
    private int femaleCount;
    private int maleCount;

    public void resetCounts(){
        femaleCount =0;
        maleCount = 0;
    }
    public void addFemale(){
        femaleCount++;
    }

    public void addMale(){
        maleCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    private boolean checked;

    public Event(String name, Sport sport) {
        this.name = name;
        this.sport = sport;
        this.checked = false;
        this.femaleCount = 0;
        this.maleCount = 0;
    }

    public int getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(int femaleCount) {
        this.femaleCount = femaleCount;
    }

    public int getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(int maleCount) {
        this.maleCount = maleCount;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean equals(Object obj) {
        boolean bool = false;
        Event aux = (Event) obj;
        if(this.name.equals(aux.name)){
            bool = true;
        }
        return bool;
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
