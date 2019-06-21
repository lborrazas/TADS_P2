package obligatorio;

import obligatorio.entities.*;
import obligatorio.entities.enumerados.MedalType;
import obligatorio.entities.enumerados.SexType;
import obligatorio.entities.nodos.ParticipationAthl;
import tad.LinkedList;
import tad.MinHeap;
import tad.SeparateChainingHashTable;

import java.util.ArrayList;

public class Consultas {
    CargaDeDatos cdd;
    ArrayList<Athlete> athletes;
    SeparateChainingHashTable<ParticipationAthl> participations;
    MinHeap<Integer, Athlete> athleteMinHeap;
    MinHeap<Integer, NationalOlympicCommittee> regionMinHeap;
    ArrayList<NationalOlympicCommittee> regions;
    SeparateChainingHashTable<NationalOlympicCommittee> regionHash;
    SeparateChainingHashTable<OlympicGame> olympicGameHash;
    MinHeap<Integer, Athlete> minHeap;
    ArrayList<AthleteOlympicParticipation> participationArrayList;
    ArrayList<Event> events;
    MinHeap<Integer, Event> eventHeap;
    MinHeap<Float, Team> teamsHeap;
    ArrayList<Team> teams;
    ArrayList<OlympicGame> olympicGames;

    public Consultas(CargaDeDatos cdd) {
        this.cdd = cdd;
        this.athletes = cdd.getAthleteList();
        this.participations = cdd.getParticipationAthlete();
        this.regions = cdd.getRegionsArrayList();
        athleteMinHeap = new MinHeap<>(150000);
        regionMinHeap = new MinHeap<>(300);
        regionHash = cdd.getCommitteHash();
        this.olympicGameHash = cdd.getOlympicGameHash();
        minHeap = new MinHeap<>(150000);
        participationArrayList = cdd.getParticipationArrayList();
        this.events = cdd.getEvents();
        eventHeap = new MinHeap<>(150000);
        teamsHeap = new MinHeap<>(10000);
        teams = cdd.getTeams();
        olympicGames = cdd.getOlympicGameList();


    }

    public void consulta1(MedalType medalsToCount) {
        athleteMinHeap.makeEmpty();

        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            athlete.resetMedals();


            LinkedList<ParticipationAthl> participationsforAthlete = participations.getAsociatedElements(athletes.get(i).hashCode());
            for (int j = 0; j < participationsforAthlete.size(); j++) {
                AthleteOlympicParticipation participation = participationsforAthlete.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)) {
                    athlete.addParticipation(participation);
                }
            }
            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            for (int k = 0; k < athlete.getAthleteOlympicParticipations().size(); k++) {
                MedalType medal = participations.get(k).getMedal();
                switch (medal) {
                    case Gold: {
                        athlete.addGcount();
                        break;
                    }
                    case Silver: {
                        athlete.addScount();
                        break;
                    }
                    case Bronze: {
                        athlete.addBcount();
                        break;
                    }

                    default: {
                        break;
                    }
                }
            }
            Integer count;
            switch (medalsToCount) {
                case Na:
                    count = -athlete.getTotal();
                    break;
                case Bronze:
                    count = -athlete.getbCount();
                    break;
                case Silver:
                    count = -athlete.getsCount();
                    break;
                case Gold:
                    count = -athlete.getgCount();
                    break;
                default:
                    count = null;

            }

            System.out.println(i);
            athleteMinHeap.insert(count, athlete);
        }
        int aMin = 100000;
        int aMax = 0;
        ArrayList<AthleteOlympicParticipation> auxParts;
        for (int k = 0; k < 10; k++) {
            Athlete athlete = athleteMinHeap.deleteMin();
            auxParts = athlete.getAthleteOlympicParticipations();
            for (int l = 0; l < auxParts.size(); l++) {
                AthleteOlympicParticipation participation = auxParts.get(l);
                if (participation.getOlympicGame().getYear() < aMin) {
                    aMin = participation.getOlympicGame().getYear();
                }
                if (participation.getOlympicGame().getYear() > aMax) {
                    aMax = participation.getOlympicGame().getYear();
                }
            }
            System.out.println(athlete.getName() + " " + athlete.getSex() + " " + athlete.getTotal());
        }
        System.out.println("Año minimo: " + aMin + " Año Maximo: " + aMax);

    }

    public void consulta2(MedalType medalsToCount) {
        regionMinHeap.makeEmpty();
        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            athlete.resetMedals();

            LinkedList<ParticipationAthl> participationsforAthlete = participations.getAsociatedElements(athletes.get(i).hashCode());
            for (int j = 0; j < participationsforAthlete.size(); j++) {
                AthleteOlympicParticipation participation = participationsforAthlete.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)) {
                    athlete.addParticipation(participation);
                }
            }

            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            Event event;
            for (int k = 0; k < athlete.getAthleteOlympicParticipations().size(); k++) {
                AthleteOlympicParticipation participation = participations.get(k);
                MedalType medal = participation.getMedal();
                event = participation.getEvent();
                //Event event = this.olympicGameHash.get(participation.getOlympicGame()).getEvents().get(participation.getEvent());
                switch (medal) {
                    case Gold: {
                        athlete.addGcount();
                        athlete.getRegion().addGcount();
                        break;
                    }
                    case Silver: {
                        athlete.addScount();
                        athlete.getRegion().addScount();
                        break;
                    }
                    case Bronze: {
                        athlete.addBcount();
                        athlete.getRegion().addBcount();
                        break;
                    }

                    default: {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < regions.size(); i++) {
            System.out.println(i);
            NationalOlympicCommittee region = regions.get(i);
            Integer count;
            switch (medalsToCount) {
                case Na:
                    count = -region.getTotal();
                    break;
                case Bronze:
                    count = -region.getbCount();
                    break;
                case Silver:
                    count = -region.getsCount();
                    break;
                case Gold:
                    count = -region.getgCount();
                    break;
                default:
                    count = null;

            }

            System.out.println(i);
            regionMinHeap.insert(count, region);
        }
        for (int k = 0; k < 10; k++) {
            NationalOlympicCommittee region = regionMinHeap.deleteMin();
            System.out.println(region.getPais() + " " + region.getTotal());
        }
    }

    public Athlete[] consulta3() {
        LinkedList<OlympicGame> juegos = new LinkedList<>();
        minHeap.makeEmpty();
        MinHeap heap = new MinHeap(15000);
        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            LinkedList<ParticipationAthl> partAthl = participations.getAsociatedElements(athletes.get(i).hashCode());

            for (int j = 0; j < partAthl.size(); j++) {
                AthleteOlympicParticipation participation = partAthl.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)) {
                    athlete.addParticipation(participation);
                }
            }
            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            OlympicGame juego;
            for (int k = 0; k < athlete.getAthleteOlympicParticipations().size(); k++) {
                juego = athlete.getAthleteOlympicParticipations().get(k).getOlympicGame();
                if (!juegos.contains(juego)) {
                    juegos.add(juego);
                    if (athlete.getSex() == SexType.FEMALE) {
                        juego.setNrodeF(juego.getNrodeF() + 1);
                    } else if (athlete.getSex() == SexType.MALE) {
                        juego.setNrodeM(juego.getNrodeM() + 1);
                    }
                } else {
                    if (athlete.getSex() == SexType.FEMALE) {
                        juego.setNrodeF(juego.getNrodeF() + 1);
                    } else {
                        juego.setNrodeM(juego.getNrodeM() + 1);
                    }
                }
            }
        }
        for (int j = 0; j < juegos.size(); j++) {
            heap.insert(-juegos.get(j).getNrodeF(), juegos.get(j).getName());
        }
        for (int t = 0; t < 10; t++) {
            System.out.println(heap.deleteMin());
        }
        return null;
    }

    public void consulta4(SexType sexType) {
        for (int i = 0; i < events.size(); i++) events.get(i).resetCounts();

        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);

            LinkedList<ParticipationAthl> participationsforAthlete = participations.getAsociatedElements(athletes.get(i).hashCode());
            for (int j = 0; j < participationsforAthlete.size(); j++) {
                AthleteOlympicParticipation participation = participationsforAthlete.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)) {
                    athlete.addParticipation(participation);
                }
            }

            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            Event event;
            for (int k = 0; k < athlete.getAthleteOlympicParticipations().size(); k++) {
                AthleteOlympicParticipation participation = participations.get(k);
                SexType sex = participation.getAthlete().getSex();
                event = participation.getEvent();
                //Event event = this.olympicGameHash.get(participation.getOlympicGame()).getEvents().get(participation.getEvent());
                switch (sex) {
                    case FEMALE: {
                        event.addFemale();
                        break;
                    }
                    case MALE:
                        event.addMale();
                        break;

                    default:
                        break;

                }
            }
        }

        for (int i = 0; i < events.size(); i++) {
            System.out.println(i);
            Event event = events.get(i);
            Integer count;
            switch (sexType) {
                case MALE:
                    count = -event.getMaleCount();
                    break;
                case FEMALE:
                    count = -event.getFemaleCount();
                    break;
                default:
                    count = null;

            }

            System.out.println(i);
            eventHeap.insert(count, event);
        }
        for (int k = 0; k < 10; k++) {
            Event event = eventHeap.deleteMin();
            System.out.println(event.getName());
        }

    }


    public void consulta5(int yearMin, int yearMax) {
        Team team;
        for (int i = 0; i < teams.size(); i++) teams.get(i).reset();

        for (int i = 0; i < participationArrayList.size(); i++) {
            team = participationArrayList.get(i).getTeam();
            team.addCompetidor();
        }

        for (int z = 0; z < athletes.size(); z++) {
            Athlete athlete = athletes.get(z);
            athlete.resetMedals();


            LinkedList<ParticipationAthl> participationsforAthlete = participations.getAsociatedElements(athletes.get(z).hashCode());
            for (int j = 0; j < participationsforAthlete.size(); j++) {
                AthleteOlympicParticipation participation = participationsforAthlete.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)) {
                    athlete.addParticipation(participation);
                }
            }

            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            for (int k = 0; k < athlete.getAthleteOlympicParticipations().size(); k++) {
                AthleteOlympicParticipation participation = participations.get(k);
                team = participation.getTeam();
                if (participation.getOlympicGame().getYear() > yearMin && participation.getOlympicGame().getYear() < yearMax) {
                    if (!(participation.getMedal() == MedalType.Na)) {
                        team.addMedals();
                    } else {
                    }
                }
            }
        }
        AthleteOlympicParticipation participationAux;
        Team teamAux;
        for (int i = 0; i < athletes.size(); i++) {
            System.out.println(i);
            Athlete athlete = athletes.get(i);
            ArrayList<AthleteOlympicParticipation> participationLinkedList = athlete.getAthleteOlympicParticipations();
            for (int k = 0; k < participationLinkedList.size(); k++) {
                participationAux = participationLinkedList.get(k);
                if (participationAux.getOlympicGame().getYear() > yearMin && participationAux.getOlympicGame().getYear() < yearMax) {
                    teamAux = participationAux.getTeam();
                    if (!teamsHeap.contains(teamAux)) {
                        teamsHeap.insert(-teamAux.efectivness(), teamAux);
                    }
                }
            }
        }
        for (int k = 0; k < 10; k++) {
            team = teamsHeap.deleteMin();
            System.out.println(team.getName());
        }
    }
}




