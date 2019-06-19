package obligatorio;

import obligatorio.entities.Athlete;
import obligatorio.entities.AthleteOlympicParticipation;
import obligatorio.entities.MedalType;
import tad.LinkedList;
import tad.MinHeap;
import tad.SeparateChainingHashTable;

import java.util.ArrayList;

public class Consultas {
    CargaDeDatos cdd = new CargaDeDatos();
    ArrayList<Athlete> athletes = new ArrayList<>();
    SeparateChainingHashTable<AthleteOlympicParticipation> participations = new SeparateChainingHashTable<>(100);



    public Athlete[] consulta1() {
        int gCount;
        int sCount;
        int bCount;
        int total;
        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            MinHeap<Integer,Athlete> minHeap = new MinHeap(150000);

            LinkedList<AthleteOlympicParticipation> participationsforAthlete = participations.getAsociatedElements(athletes.get(i).hashCode());
            for (int j = 0; j < participationsforAthlete.size(); j++) {
                AthleteOlympicParticipation participation =participationsforAthlete.get(j);
                if (participation.getAthlete().equals(athlete)){
                    athlete.addParticipation(participation);
                }
            }
            ArrayList<AthleteOlympicParticipation> participations = athlete.getAthleteOlympicParticipations();
            for(int k=0; k<athlete.getAthleteOlympicParticipations().size(); k++){
                MedalType medal = participations.get(k).getMedal();
                switch()
            }
            minHeap.insert(3,athlete);
        }

    }
}
