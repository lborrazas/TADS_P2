package obligatorio;

import obligatorio.entities.*;
import tad.LinkedList;
import tad.SeparateChainingHashTable;

import java.io.BufferedReader;
import java.io.FileReader;

public class CargaDeDatos {
    private LinkedList<NationalOlympicCommittee> committeeLinkedList = new LinkedList<>();
    private SeparateChainingHashTable<NationalOlympicCommittee> committeHash = new SeparateChainingHashTable<>(11);
    private SeparateChainingHashTable<AthleteNRegion> athleteHashNOC = new SeparateChainingHashTable<>(11);
    private SeparateChainingHashTable<AthleteNTeam> athleteHashTEAM = new SeparateChainingHashTable<>(11);
    private SeparateChainingHashTable<participationAthl> participationAthlete = new SeparateChainingHashTable<>(11);
    private SeparateChainingHashTable<participationTeam> participationTeam = new SeparateChainingHashTable<>(11);

    public static void main(String[] args) throws Exception { //orden de megas estamos bien

        BufferedReader br = new BufferedReader(new FileReader("resources/noc_regions.csv"));
        CargaDeDatos cdd = new CargaDeDatos();
        String line = null;
        double startTime = System.nanoTime();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (values.length == 2) {
                cdd.chargeListCommittee(values[0], values[1]);
                cdd.chargeHashCommittee(values[0], values[1]);
            } else if (values.length == 3) {
                cdd.chargeHashCommittee(values[0], values[1], values[2]);
                cdd.chargeListCommittee(values[0], values[1], values[2]);
            }
        }
        System.out.println(cdd.committeHash.getCurrentSize());
        NationalOlympicCommittee nationalOlympicCommittee = new NationalOlympicCommittee("ALG", "Mate");
        LinkedList<NationalOlympicCommittee> list = cdd.committeHash.getAsociatedElements(nationalOlympicCommittee.hashCode());
        System.out.println(list.get(0).getCode());

        double endTime = System.nanoTime();
        System.out.println("Carga de Datos: " + (endTime - startTime) / 1000000000 + " s");
        br.close();
        br = new BufferedReader(new FileReader("resources/athlete_events.csv"));

//        String line2 = null;
//        double startTime2 = System.nanoTime();
//        while ((line = br.readLine()) != null) {
//            String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//
//
//        }
    }
    private NationalOlympicCommittee chargeListCommittee(String code, String country ){
        NationalOlympicCommittee temp = new NationalOlympicCommittee(code, country);
        committeeLinkedList.add(temp);
       return temp;
    }

    private NationalOlympicCommittee chargeListCommittee(String code, String country, String notes ){
        NationalOlympicCommittee temp = new NationalOlympicCommittee(code, country, notes);
       committeeLinkedList.add(temp);
       return temp;
    }

    private void chargeHashCommittee (String code, String country ){
        NationalOlympicCommittee temp = new NationalOlympicCommittee(code, country);
        committeHash.insert(temp);
    }

    private void chargeHashCommittee (String code, String country, String notes ){
        NationalOlympicCommittee temp = new NationalOlympicCommittee(code, country, notes);
        committeHash.insert(temp);
    }


}
