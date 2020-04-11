package com.codecool.lifeOfTheAnts;

import com.codecool.lifeOfTheAnts.Bugs.*;

import java.util.ArrayList;

public class Colony {
    private Food food = new Food();
    private Wasp wasp = new Wasp();
    private ArrayList<Ant> antColony = new ArrayList<>();
    private ArrayList<Ant> deathAnt = new ArrayList<>();


    public Food getFood() { return food; }

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
        for (Ant ant : antColony) {
            ant.action(this);
            if (ant.getLifeTime() == 0) {
                deathAnt.add(ant);
            }
        }
        removeDeathAnts();
        if (RandomGenerate.randomGenerate(100, 0) <= 1 && !wasp.isLive()){
            wasp.waspWokenUp();
        }
        if (RandomGenerate.randomGenerate(100, 0) <= 10 && !food.isSpawn()){
            food.spawnFood();
        }
        if (((Queen) antColony.get(0)).isEggHatching()){
            newAntBorn();
            ((Queen) antColony.get(0)).setEggHatching(false);
        }
    }

//    public boolean stepChecker(ArrayList<Coordinate> steps, int x, int y){
//        for (Coordinate coordinate: steps){
//            if (coordinate.getxCoordinate() == x && coordinate.getyCoordinate() == y){
//                return true;
//            }
//        }
//        return false;
//    }

    public void removeDeathAnts(){
        if (deathAnt.size() != 0){
            antColony.removeAll(deathAnt);
            deathAnt = new ArrayList<>();
        }
    }

    public void newAntBorn(){
        int eggNumber = RandomGenerate.randomGenerate(15, 7);
        for (int i = 0; i < eggNumber; i++){
            int antHatch = RandomGenerate.randomGenerate(100, 0);
            if (antHatch < 40){
                antColony.add(new Soldier());
            } else if (antHatch > 60){
                antColony.add(new Drone());
            } else {
                antColony.add(new Worker());
            }
        }
    }
}
