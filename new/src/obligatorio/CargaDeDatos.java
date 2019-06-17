package obligatorio;

import obligatorio.entities.NationalOlympicCommittee;
import tad.SeparateChainingHashTable;

import java.io.BufferedReader;
import java.io.FileReader;

public class CargaDeDatos {
    private SeparateChainingHashTable<NationalOlympicCommittee> committeeHash = new SeparateChainingHashTable<>(11);


    public static void main(String[] args) throws Exception { //orden de megas estamos bien

        BufferedReader br = new BufferedReader(new FileReader("resources/noc_regions.csv"));
        CargaDeDatos cdd = new CargaDeDatos();
        String line = null;
        double startTime = System.nanoTime();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (values.length == 2) {
                cdd.chargeCommittee(values[0], values[1]);
            }
            else if (values.length == 3){
                cdd.chargeCommittee(values[0], values[1], values[2]);
            }
        }
        System.out.println(cdd.committeeHash.getCurrentSize());
        double endTime = System.nanoTime();
        System.out.println("Carga de Datos: " + (endTime - startTime)/1000000000 + " s");
        br.close();
        br = new BufferedReader(new FileReader("resources/athlete_events.csv"));
    }

    private void chargeCommittee(String code, String country ){
        NationalOlympicCommittee temp = new NationalOlympicCommittee(code, country);
        committeeHash.insert(temp);
    }

    private void chargeCommittee(String code, String country, String notes ){
        NationalOlympicCommittee temp = new NationalOlympicCommittee(code, country, notes);
        committeeHash.insert(temp);
    }
}
