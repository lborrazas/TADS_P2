package obligatorio;

import obligatorio.entities.*;
import obligatorio.entities.enumerados.MedalType;
import obligatorio.entities.enumerados.SeasonType;
import obligatorio.entities.enumerados.SexType;
import obligatorio.entities.nodos.AthleteNRegion;
import obligatorio.entities.nodos.AthleteNTeam;
import obligatorio.entities.nodos.ParticipationAthl;
import obligatorio.entities.nodos.ParticipationOlympicGame;
import tad.LinkedList;
import tad.SeparateChainingHashTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CargaDeDatos {
    private SeparateChainingHashTable<NationalOlympicCommittee> committeHash = new SeparateChainingHashTable<>(11);
    private SeparateChainingHashTable<Team> teamHash = new SeparateChainingHashTable<>(300);
    private SeparateChainingHashTable<City> cityHash = new SeparateChainingHashTable<>(10000);
    private SeparateChainingHashTable<Sport> sportHash = new SeparateChainingHashTable<>(10000);
    private SeparateChainingHashTable<AthleteNRegion> athleteHashNOC = new SeparateChainingHashTable<>(150000);
    private SeparateChainingHashTable<ParticipationAthl> participationAthlete = new SeparateChainingHashTable<>(130000);
    private SeparateChainingHashTable<Athlete> athelteHash = new SeparateChainingHashTable<>(150000);
    private SeparateChainingHashTable<OlympicGame> olympicGameHash = new SeparateChainingHashTable<>(300);
    private SeparateChainingHashTable<Event> eventHash = new SeparateChainingHashTable<>(1000);
    private ArrayList<Event> events = new ArrayList<>(1000);
    private ArrayList<Team> teams = new ArrayList<>(1000);
    private ArrayList<NationalOlympicCommittee> regionsArrayList = new ArrayList<>(300);
    private ArrayList<AthleteOlympicParticipation> participationArrayList = new ArrayList<>(250000);
    private ArrayList<OlympicGame> olympicGameList = new ArrayList<>(300);
    private ArrayList<Athlete> athleteList = new ArrayList<>(150000);
    //    private SeparateChainingHashTable<AthleteNTeam> athleteHashTEAM = new SeparateChainingHashTable<>(250);
    // private SeparateChainingHashTable<ParticipationOlympicGame> participationTeam = new SeparateChainingHashTable<>(100);
    public SeparateChainingHashTable<OlympicGame> getOlympicGameHash() {

        return olympicGameHash;
    }

    public void main() throws Exception { //orden de megas estamos bien

        BufferedReader br = new BufferedReader(new FileReader("resources/noc_regions.csv"));
        String line = null;
        double startTime = System.nanoTime();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (values[0].equals("SIN")) {
                values[0] = "SGP";
            }
            if (values.length == 2) {
                NationalOlympicCommittee region = new NationalOlympicCommittee(values[0], values[1]);
                regionsArrayList.add(region);
                committeHash.insert(region);

            } else if (values.length == 3) {

                NationalOlympicCommittee region = new NationalOlympicCommittee(values[0], values[1], values[2]);
                regionsArrayList.add(region);
                committeHash.insert(region);
            }
        }
        NationalOlympicCommittee nationalOlympicCommittee = new NationalOlympicCommittee("ALG", "Mate");
        LinkedList<NationalOlympicCommittee> list = this.committeHash.getAsociatedElements(nationalOlympicCommittee.hashCode());

        br.close();


        String valueCeroPrev = null;
        Team team;
        LinkedList<NationalOlympicCommittee> auxList;
        NationalOlympicCommittee toAddNoc;
        Long lg;
        SexType sex;
        Integer edad = 0;
        Float altura = 0f;
        Float peso = 0f;
        Athlete auxAthlete;
        AthleteNRegion athleteNRegion;
        AthleteNTeam athleteNTeam;
        SeasonType season;
        City city;
        Sport sport;
        Event event;
        OlympicGame olympicGameAux;
        NationalOlympicCommittee auxNoc;
        MedalType medal;
        AthleteOlympicParticipation participation;
        ParticipationAthl participationAthl;
        ParticipationOlympicGame participationOlympicGame;

        br = new BufferedReader(new FileReader("resources/athlete_events.csv"));
        String line2 = br.readLine();
        while ((line2 = br.readLine()) != null) {

            String[] values = line2.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (int i = 0; i < values.length; i++) {
                if (values[i].charAt(0) == '"') {
                    values[i] = values[i].substring(1, values[i].length() - 1);
                }
            }

            team = new Team(values[6]);
            if (teamHash.contains(team)) {
                team = teamHash.get(team);
            } else {
                teamHash.insert(team);
                teams.add(team);
            }


            auxNoc = new NationalOlympicCommittee(values[7], null);
            toAddNoc = committeHash.get(auxNoc);


            lg = null;
            sex = null;

            if (values[2].equals("F")) {
                sex = SexType.FEMALE;
            } else if (values[2].equals("M")) {
                sex = SexType.MALE;
            }

            edad = 0;
            altura = 0f;
            peso = 0f;

            if (!values[3].equals("NA") && !values[4].equals("NA") && !values[5].equals("NA")) {
                edad = Integer.parseInt(values[3]);
                altura = Float.parseFloat(values[4]);
                peso = Float.parseFloat(values[5]);
            }


            auxAthlete = new Athlete((lg.valueOf(values[0])), values[1], sex, edad, altura, peso, team, toAddNoc);

            if (!values[0].equals(valueCeroPrev)) {
                this.athelteHash.insert(auxAthlete);
                athleteNRegion = new AthleteNRegion(auxAthlete);
                athleteNTeam = new AthleteNTeam(auxAthlete);
                this.athleteList.add(auxAthlete);
                this.athleteHashNOC.insert(athleteNRegion);
//              this.athleteHashTEAM.insert(athleteNTeam);
            } else {
                auxAthlete = this.athelteHash.get(auxAthlete);
            }

            valueCeroPrev = values[0];

            season = null;
            if (values[10].equals("Winter")) {
                season = SeasonType.Winter;
            } else if (values[10].equals("Summer")) {
                season = SeasonType.Summer;
            }

            city = new City(values[11]);
            if (cityHash.contains(city)) {
                city = cityHash.get(city);
            } else {
                cityHash.insert(city);
            }
            sport = new Sport(values[12]);
            if (sportHash.contains(sport)) {
                sport = sportHash.get(sport);
            } else {
                sportHash.insert(sport);
            }

            event = new Event(values[13], sport);
            if(events.contains(event)){
                event = eventHash.get(event);
            } else{
                events.add(event);
                eventHash.insert(event);
            }


            olympicGameAux = new OlympicGame(values[8], Integer.parseInt(values[9]), season, city);

            if (this.olympicGameHash.contains(olympicGameAux)) {
                olympicGameAux = this.olympicGameHash.get(olympicGameAux);
                if (!olympicGameAux.getEvents().contains(event)) {
                    olympicGameAux.getEvents().add(event);
                } else {
                    event = olympicGameAux.getEvents().get(event);
                }
            } else {
                olympicGameAux.getEvents().add(event);
                this.olympicGameHash.insert(olympicGameAux);
            }


            if (values[14].equals("Bronze")) {
                medal = MedalType.Bronze;
            } else if (values[14].equals("Silver")) {
                medal = MedalType.Silver;
            } else if (values[14].equals("Gold")) {
                medal = MedalType.Gold;
            } else {
                medal = MedalType.Na;
            }
            participation = new AthleteOlympicParticipation(medal, event, olympicGameAux, auxAthlete);
            participationArrayList.add(participation);

            participationAthl = new ParticipationAthl(participation);
            participationOlympicGame = new ParticipationOlympicGame(participation);

            if (!this.participationAthlete.contains(participationAthl)) {
                this.participationAthlete.insert(participationAthl);
                //  this.participationTeam.insert(participationOlympicGame);
            }


        }
        double endTime = System.nanoTime();
        System.out.println("Carga de Datos: " + (endTime - startTime) / 1000000000 + " s");

    }

    public ArrayList<NationalOlympicCommittee> getRegionsArrayList() {
        return regionsArrayList;
    }


    public SeparateChainingHashTable<NationalOlympicCommittee> getCommitteHash() {
        return committeHash;
    }


    public SeparateChainingHashTable<AthleteNRegion> getAthleteHashNOC() {
        return athleteHashNOC;
    }

//    public SeparateChainingHashTable<AthleteNTeam> getAthleteHashTEAM() {
//        return athleteHashTEAM;
//    }
//
//    public void setAthleteHashTEAM(SeparateChainingHashTable<AthleteNTeam> athleteHashTEAM) {
//        this.athleteHashTEAM = athleteHashTEAM;*/
//   }

    public SeparateChainingHashTable<ParticipationAthl> getParticipationAthlete() {
        return participationAthlete;
    }


//    public SeparateChainingHashTable<ParticipationOlympicGame> getParticipationTeam() {
//        return participationTeam;
//    }
//
//    public void setParticipationTeam(SeparateChainingHashTable<ParticipationOlympicGame> participationTeam) {
//        this.participationTeam = participationTeam;
//    }

    public ArrayList<Athlete> getAthleteList() {
        return athleteList;
    }

    public SeparateChainingHashTable<Team> getTeamHash() {
        return teamHash;
    }

    public SeparateChainingHashTable<Athlete> getAthelteHash() {
        return athelteHash;
    }

    public SeparateChainingHashTable<City> getCityHash() {
        return cityHash;
    }

    public SeparateChainingHashTable<Sport> getSportHash() {
        return sportHash;
    }

    public ArrayList<AthleteOlympicParticipation> getParticipationArrayList() {
        return participationArrayList;
    }

    public ArrayList<OlympicGame> getOlympicGameList() {
        return olympicGameList;
    }

    public SeparateChainingHashTable<Event> getEventHash() {
        return eventHash;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}
