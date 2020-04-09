package com.codecool.lifeOfTheAnts;

import com.codecool.lifeOfTheAnts.Bugs.*;

import java.util.ArrayList;

public class Colony {
    private Wasp wasp = new Wasp();
    private ArrayList<Ant> antColony = new ArrayList<>();


    public Wasp getWasp() {
        return wasp;
    }

    public ArrayList<Ant> getAntColony() {
        return antColony;
    }

    public void setAntColony(){
        antColony.add(new Queen());
        antColony.add(new Soldier());
        antColony.add(new Soldier());
        antColony.add(new Soldier());
        antColony.add(new Drone());
        antColony.add(new Drone());
        antColony.add(new Worker());
        antColony.add(new Worker());
        antColony.add(new Worker());
        antColony.add(new Worker());
        antColony.add(new Worker());
    }

    public void stepTime(){
        if (RandomGenerate.randomGenerate(100, 0) <= 5){
            wasp.waspWokenUp();
        }
        for (Ant ant: antColony){
            ant.action(this);
        }
    }
}
