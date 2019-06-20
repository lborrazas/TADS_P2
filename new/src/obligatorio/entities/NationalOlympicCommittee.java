package obligatorio.entities;

public class NationalOlympicCommittee {
    private String code;
    private String pais;
    private String notes;
    private int gCount;
    private int sCount;
    private int bCount;
    private int total;

    public NationalOlympicCommittee(String code, String country) {
        this.code = code;
        this.pais = country;
        this.notes = null;
    }

    public NationalOlympicCommittee(String code, String country, String notes) {
        this.code = code;
        this.pais = pais;
        this.notes = notes;
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

    public void resetMedals() {
        this.sCount = 0;
        this.bCount = 0;
        this.gCount = 0;
        this.total = 0;
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
        int hashVal = 0;
        for (int i = 0; i < this.code.length(); i++)
            hashVal = 37 * hashVal + this.code.charAt(i);
        return hashVal;
    }


    public boolean equals(Object obj) {
        boolean bool = false;
       NationalOlympicCommittee aux = (NationalOlympicCommittee) obj;
       if(this.code.equals(aux.code))bool = true;
       return bool;
    }

    public String getCode() {
        return code;
    }

    public String getPais() {
        return pais;
    }
}
