package obligatorio.entities;

public class NationalOlympicCommittee {
    private String code;
    private String pais;
    private String notes;

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

    public int hashCode() {
        int hashVal = 0;
        for( int i = 0; i < this.code.length( ); i++ )
            hashVal = 37 * hashVal + this.code.charAt( i );
        return hashVal;
    }

    public String getCode() {
        return code;
    }

    public String getPais() {
        return pais;
    }
}
