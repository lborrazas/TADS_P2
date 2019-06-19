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
    MinHeap<Integer,Athlete> minHeap;

    public Consultas(CargaDeDatos cdd) {
        this.cdd = cdd;
        this.athletes = cdd.getAthleteList();
        this.participations = cdd.getParticipationAthlete();
        minHeap = new MinHeap<>(150000);
    }

    public Athlete[] consulta1() {


        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);


            LinkedList<ParticipationAthl> participationsforAthlete = participations.getAsociatedElements(athletes.get(i).hashCode());
            for (int j = 0; j < participationsforAthlete.size(); j++) {
                AthleteOlympicParticipation participation =participationsforAthlete.get(j).getParticipation();
                if (participation.getAthlete().equals(athlete)){
                    athlete.addParticipation(participation);
                }
            }
            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            for(int k=0; k<athlete.getAthleteOlympicParticipations().size(); k++){
                MedalType medal = participations.get(k).getMedal();
                switch(medal){
                    case Gold: {
                        athlete.addGcount();
                        break;
                    }
                    case Silver:{
                        athlete.addScount();
                        break;
                    }
                    case Bronze:{
                        athlete.addBcount();
                        break;
                    }
                }
            }
            Integer count = -athlete.getTotal();
            minHeap.insert(-count,athlete);
        }
        for(int k=0; k<10; k++){
            Athlete athlete = minHeap.getMin();
            System.out.println(athlete.getName());
        }
return null;
    }
}
