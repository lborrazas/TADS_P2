package obligatorio;

import obligatorio.entities.*;
import tad.LinkedList;
import tad.SeparateChainingHashTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CargaDeDatos {
    private LinkedList<NationalOlympicCommittee> committeeLinkedList = new LinkedList<>();
    private SeparateChainingHashTable<NationalOlympicCommittee> committeHash = new SeparateChainingHashTable<>(11);
    private SeparateChainingHashTable<AthleteNRegion> athleteHashNOC = new SeparateChainingHashTable<>(250);
    private SeparateChainingHashTable<AthleteNTeam> athleteHashTEAM = new SeparateChainingHashTable<>(250);
    private SeparateChainingHashTable<participationAthl> participationAthlete = new SeparateChainingHashTable<>(130000);
    private SeparateChainingHashTable<participationTeam> participationTeam = new SeparateChainingHashTable<>(300);
    private ArrayList<Athlete> athleteList = new ArrayList<>();
    private ArrayList<OlympicGame> olympicGameList = new ArrayList<>();

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
        //Solo hay uno con este hashcode pero podrian haber mas y habira que fijarse el code o id
        System.out.println(list.get(0).getCode());

        double endTime = System.nanoTime();
        System.out.println("Carga de Datos: " + (endTime - startTime) / 1000000000 + " s");
        br.close();
        br = new BufferedReader(new FileReader("resources/athlete_events.csv"));
        String line2 = null;
        double startTime2 = System.nanoTime();
        line2 = br.readLine();
        int z = 1;
        while ((line2 = br.readLine()) != null) {
            z++;

            System.out.println(z);

            String[] values = line2.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (int i = 0 ; i< values.length ; i++){
                if (values[i].charAt(0) == '"' ){
                    values[i] = values[i].substring(1,values[i].length()-1);
                }
            }
            if (values[7].equals("SGP")){
                values[7] = "SIN";
            }
            Team team = new Team(values[6]);
            NationalOlympicCommittee auxNoc =  new NationalOlympicCommittee(values[7], null); //ToDo sacar para afuera e inicalziar adentro


            LinkedList<NationalOlympicCommittee>  auxList = cdd.committeHash.getAsociatedElements(auxNoc.hashCode());
            NationalOlympicCommittee toAddNoc = null;
            for (int i = 0; i<auxList.size();i++){
                toAddNoc =  auxList.get(i);
                if(toAddNoc.getCode().equals(values[7])){
                    break;
                }
            }
            Long lg = null;
            SexType sex = null;

            if (values[2].equals("F")){
                sex = SexType.FEMALE;
            } else if (values[2].equals("M")){
                sex = SexType.MALE;
            }

            Integer edad = 0;
            Float altura = 0f;
            Float peso = 0f;

            if (!values[3].equals("NA") && !values[4].equals("NA") && !values[5].equals("NA")){
            edad = Integer.parseInt(values[3]);
            altura = Float.parseFloat(values[4]);
            peso = Float.parseFloat(values[5]);
            }



            Athlete auxAthlete = new Athlete((lg.valueOf(values[0])),values[1],sex, edad,altura,peso,team,toAddNoc);
            AthleteNRegion athleteNRegion = new AthleteNRegion(auxAthlete);
            AthleteNTeam athleteNTeam = new AthleteNTeam(auxAthlete);

            if (!cdd.athleteList.contains(auxAthlete)){
                cdd.athleteList.add(auxAthlete);
               cdd.athleteHashNOC.insert(athleteNRegion);
                cdd.athleteHashTEAM.insert(athleteNTeam);
            }
            SeasonType season = null;
            if (values[10].equals("Winter")){
                season = SeasonType.Winter;
            } else if (values[10].equals("Summer")){
                season = SeasonType.Summer;
            }

            City city = new City(values[11]);
            Sport sport = new Sport(values[12]);
            Event event = new Event(values[13],sport);
            LinkedList<Event> eventsUno = new LinkedList<>();//ToDO hola
            eventsUno.add(event);

            OlympicGame olympicGameAux = new OlympicGame(values[8],Integer.parseInt(values[9]),season,city,eventsUno);
            boolean agregado = false;
            for (int i = 0 ; i < cdd.olympicGameList.size() ; i++){
                OlympicGame auxI = cdd.olympicGameList.get(i);
                if (auxI.equals(olympicGameAux)){
                    auxI.getEvents().add(event);
                    agregado = true;
                }
            }
            if (!agregado){
                cdd.olympicGameList.add(olympicGameAux);
            }

            MedalType medal = null;
            if(values[14].equals("Bronze")){
                medal = MedalType.Bronze;
            } else if (values[14].equals("Silver")){
                medal = MedalType.Silver;
            } else if (values[14].equals("Gold")){
                medal = MedalType.Gold;
            } else {
                medal = null;
            }
            AthleteOlympicParticipation participation = new AthleteOlympicParticipation(medal, event, olympicGameAux, auxAthlete);
            participationAthl participationAthl = new participationAthl(participation);
            participationTeam participationTeam = new participationTeam(participation);

            if (!cdd.participationAthlete.contains(participationAthl)){
                cdd.participationAthlete.insert(participationAthl);
                cdd.participationTeam.insert(participationTeam);
            }


        }

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
