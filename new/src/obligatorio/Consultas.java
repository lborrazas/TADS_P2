package obligatorio;

import obligatorio.entities.*;
import tad.LinkedList;
import tad.MinHeap;
import tad.SeparateChainingHashTable;

import java.util.ArrayList;

public class Consultas {
    CargaDeDatos cdd;
    ArrayList<Athlete> athletes;
    SeparateChainingHashTable<ParticipationAthl> participations;
    MinHeap<Integer, Athlete> minHeap;

    public Consultas(CargaDeDatos cdd) {
        this.cdd = cdd;
        this.athletes = cdd.getAthleteList();
        this.participations = cdd.getParticipationAthlete();
        minHeap = new MinHeap<>(150000);
    }

    public Athlete[] consulta1(MedalType medalsToCount) {
        minHeap.makeEmpty();

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
            minHeap.insert(count, athlete);
        }
        for (int k = 0; k < 10; k++) {
            Athlete athlete = minHeap.deleteMin();
            System.out.println(athlete.getName());

        }
        return null;
    }

    public Athlete[] consulta3() {

        LinkedList<OlympicGame> juegos = null;
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
                    }
                } else {
                    if (athlete.getSex() == SexType.FEMALE) {
                        juego.setNrodeF(juego.getNrodeF() + 1);
                    }
                }
            }
        }
        return null;
    }
}
