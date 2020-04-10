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
        for (int i = 0; i < Main.getSolderNumber(); i++){
            antColony.add(new Soldier());
        }
        for (int i = 0; i < Main.getDroneNumber(); i++){
            antColony.add(new Drone());
        }
        for (int i = 0; i < Main.getWorkerNumber(); i++){
            antColony.add(new Worker());
        }
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
