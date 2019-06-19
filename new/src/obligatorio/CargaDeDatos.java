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
    private SeparateChainingHashTable<ParticipationAthl> participationAthlete = new SeparateChainingHashTable<>(130000);
    private SeparateChainingHashTable<ParticipationTeam> participationTeam = new SeparateChainingHashTable<>(300);
    private ArrayList<Athlete> athleteList = new ArrayList<>();
    private ArrayList<OlympicGame> olympicGameList = new ArrayList<>();

    public void main() throws Exception { //orden de megas estamos bien

        BufferedReader br = new BufferedReader(new FileReader("resources/noc_regions.csv"));
        //CargaDeDatos this = new CargaDeDatos();
        String line = null;
        double startTime = System.nanoTime();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (values.length == 2) {
                this.chargeListCommittee(values[0], values[1]);
                this.chargeHashCommittee(values[0], values[1]);
            } else if (values.length == 3) {
                this.chargeHashCommittee(values[0], values[1], values[2]);
                this.chargeListCommittee(values[0], values[1], values[2]);
            }
        }
        System.out.println(this.committeHash.getCurrentSize());
        NationalOlympicCommittee nationalOlympicCommittee = new NationalOlympicCommittee("ALG", "Mate");
        LinkedList<NationalOlympicCommittee> list = this.committeHash.getAsociatedElements(nationalOlympicCommittee.hashCode());
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


            LinkedList<NationalOlympicCommittee>  auxList = this.committeHash.getAsociatedElements(auxNoc.hashCode());
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

            if (!this.athleteList.contains(auxAthlete)){
                this.athleteList.add(auxAthlete);
               this.athleteHashNOC.insert(athleteNRegion);
                this.athleteHashTEAM.insert(athleteNTeam);
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
            for (int i = 0 ; i < this.olympicGameList.size() ; i++){
                OlympicGame auxI = this.olympicGameList.get(i);
                if (auxI.equals(olympicGameAux)){
                    auxI.getEvents().add(event);
                    agregado = true;
                }
            }
            if (!agregado){
                this.olympicGameList.add(olympicGameAux);
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
            ParticipationAthl participationAthl = new ParticipationAthl(participation);
            ParticipationTeam participationTeam = new ParticipationTeam(participation);

            if (!this.participationAthlete.contains(participationAthl)){
                this.participationAthlete.insert(participationAthl);
                this.participationTeam.insert(participationTeam);
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


    public LinkedList<NationalOlympicCommittee> getCommitteeLinkedList() {
        return committeeLinkedList;
    }

    public void setCommitteeLinkedList(LinkedList<NationalOlympicCommittee> committeeLinkedList) {
        this.committeeLinkedList = committeeLinkedList;
    }

    public SeparateChainingHashTable<NationalOlympicCommittee> getCommitteHash() {
        return committeHash;
    }

    public void setCommitteHash(SeparateChainingHashTable<NationalOlympicCommittee> committeHash) {
        this.committeHash = committeHash;
    }

    public SeparateChainingHashTable<AthleteNRegion> getAthleteHashNOC() {
        return athleteHashNOC;
    }

    public void setAthleteHashNOC(SeparateChainingHashTable<AthleteNRegion> athleteHashNOC) {
        this.athleteHashNOC = athleteHashNOC;
    }

    public SeparateChainingHashTable<AthleteNTeam> getAthleteHashTEAM() {
        return athleteHashTEAM;
    }

    public void setAthleteHashTEAM(SeparateChainingHashTable<AthleteNTeam> athleteHashTEAM) {
        this.athleteHashTEAM = athleteHashTEAM;
    }

    public SeparateChainingHashTable<ParticipationAthl> getParticipationAthlete() {
        return participationAthlete;
    }

    public void setParticipationAthlete(SeparateChainingHashTable<ParticipationAthl> participationAthlete) {
        this.participationAthlete = participationAthlete;
    }

    public SeparateChainingHashTable<ParticipationTeam> getParticipationTeam() {
        return participationTeam;
    }

    public void setParticipationTeam(SeparateChainingHashTable<ParticipationTeam> participationTeam) {
        this.participationTeam = participationTeam;
    }

    public ArrayList<Athlete> getAthleteList() {
        return athleteList;
    }

    public void setAthleteList(ArrayList<Athlete> athleteList) {
        this.athleteList = athleteList;
    }

    public ArrayList<OlympicGame> getOlympicGameList() {
        return olympicGameList;
    }

    public void setOlympicGameList(ArrayList<OlympicGame> olympicGameList) {
        this.olympicGameList = olympicGameList;
    }
}
