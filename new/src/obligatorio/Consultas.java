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
        for (int k = 0; k < 10; k++) {
            Athlete athlete = athleteMinHeap.deleteMin();
            System.out.println(athlete.getName());

        }
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
                       // athlete.getRegion().addGcount();
                       if (!event.isChecked()) {
                            athlete.getRegion().addGcount();
                            event.setChecked(true);
                        }

                        break;
                    }
                    case Silver: {
                        athlete.addScount();
                      //  athlete.getRegion().addScount();
                        if (!event.isChecked()) {
                            athlete.getRegion().addScount();
                            event.setChecked(true);
                        }

                        break;
                    }
                    case Bronze: {
                        athlete.addBcount();
                       // athlete.getRegion().addBcount();
                       if (!event.isChecked()) {
                            athlete.getRegion().addBcount();
                            event.setChecked(true);
                        }
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
            NationalOlympicCommittee region =regions.get(i);
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
            System.out.println(region.getPais());

        }
    }

    public Athlete[] consulta3(){
        LinkedList<OlympicGame> juegos =new LinkedList<>();
        minHeap.makeEmpty();
        MinHeap heap = new MinHeap(15000);
        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            LinkedList<ParticipationAthl> partAthl = participations.getAsociatedElements(athletes.get(i).hashCode());

            for (int j = 0; j < partAthl.size(); j++) {
                AthleteOlympicParticipation participation =partAthl.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)){
                    athlete.addParticipation(participation);
                }
            }
            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            OlympicGame juego;
            for(int k=0; k<athlete.getAthleteOlympicParticipations().size(); k++){
                juego = athlete.getAthleteOlympicParticipations().get(k).getOlympicGame();
                if (!juegos.contains(juego)){
                    juegos.add(juego);
                    if (athlete.getSex() == SexType.FEMALE) {
                        juego.setNrodeF(juego.getNrodeF() + 1);
                    } else if (athlete.getSex() == SexType.MALE){
                        juego.setNrodeM(juego.getNrodeM()+1);
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
        for (int j = 0 ; j < juegos.size() ; j++){
            heap.insert(-juegos.get(j).getNrodeF(), juegos.get(j).getName());
        }
        for (int t = 0 ; t< 10; t++){
            System.out.println(heap.deleteMin());
        }
        return null;
    }

    public Athlete [] consulta4() {
        LinkedList<OlympicGame> juegos = new LinkedList<>();
        minHeap.makeEmpty();
        LinkedList<Event> eventos = new LinkedList<>();
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
                }
            }
            for (int t = 0 ; t < juegos.size() ; t++){
                for (int r = 0; r < juegos.get(t).getEvents().size()-1; r++){
                    if (!eventos.contains(juegos.get(t).getEvents().get(r))){
                        eventos.add(juegos.get(t).getEvents().get(r));
                    }
                    // System.out.println(eventos.get(r).getName());
                    if (athlete.getSex() == SexType.FEMALE){
                        eventos.get(r).setNrodeF(eventos.get(r).getNrodeF()+1);
                        // eventos.get(juegos.get(t).getEvents().get(r)).setNrodeF(eventos.get(juegos.get(t).getEvents().get(r)).getNrodeF()+1);
                    } else {
                        eventos.get(r).setNrodeM(eventos.get(r).getNrodeM()+1);
                        //eventos.get(juegos.get(t).getEvents().get(r)).setNrodeM(eventos.get(juegos.get(t).getEvents().get(r)).getNrodeM()+1);
                    }
                }

            }
            System.out.println("je");
        }
        System.out.println(eventos.size());
        for(int k = 0 ; k < eventos.size() ; k++){
            heap.insert(-eventos.get(k).getNrodeF(),eventos.get(k));
        }
        System.out.println(heap.getSize());
        for (int i = 0 ; i < 10 ; i++){
            System.out.println(heap.deleteMin());
        }
        System.out.println("tamo");
        return null;
    }

    public void consulta5(){
        LinkedList<OlympicGame> juegos = new LinkedList<>();
        minHeap.makeEmpty();
        LinkedList<Event> eventos = new LinkedList<>();
        MinHeap heap = new MinHeap(15000);
        LinkedList<Team> teams = new LinkedList<>();
        float efectividad = 0;
        System.out.println(athletes.size());
        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            LinkedList<ParticipationAthl> partAthl = participations.getAsociatedElements(athletes.get(i).hashCode());

            for (int j = 0; j < partAthl.size(); j++) {
                AthleteOlympicParticipation participation = partAthl.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)) {
                    athlete.addParticipation(participation);
                }
            }
            //   ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            Team team;
            //  System.out.println(athlete.getAthleteOlympicParticipations().size());
            for (int k = 0; k < athlete.getAthleteOlympicParticipations().size(); k++) {
                team = athlete.getAthleteOlympicParticipations().get(k).getAthlete().getTeam();
                if (!teams.contains(team)) {
                    teams.add(team);
                }
                team.setCompetidores(team.getCompetidores()+1);
            }
            System.out.println(teams.size());
            for (int t = 0; t < teams.size(); t++){
                team = teams.get(t);
                team.setMedals(team.getMedals()+athlete.getTotal());
                team.setEfectividad(team.getMedals()/team.getCompetidores());
            }

            //   System.out.println("je");
        }
        for (int j = 0 ; j < teams.size(); j++){
            heap.insert(-teams.get(j).getEfectividad(),teams.get(j).getName());
        }
        for (int k = 0; k < 5 ; k++){
            System.out.println(heap.deleteMin());
        }

    }

}
