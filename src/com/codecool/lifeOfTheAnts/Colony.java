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
        ArrayList<Coordinate> steps = new ArrayList<>();
        for (Ant ant : antColony) {
            int beforeStepX = ant.getX();
            int beforeStepY = ant.getY();
            ant.action(this);
            while (stepChecker(steps, ant.getX(), ant.getY())) {
                ant.setX(beforeStepX);
                ant.setY(beforeStepY);
            }
            if (ant.getLifeTime() > 0) {
                steps.add(new Coordinate(ant.getX(), ant.getY()));
            } else {
                deathAnt.add(ant);
            }
        }
        removeDeathAnts(antColony);
        if (RandomGenerate.randomGenerate(100, 0) <= 5 && !wasp.isLive()){
            wasp.waspWokenUp();
        }
        if (RandomGenerate.randomGenerate(100, 0) <= 10 && !food.isSpawn()){
            food.spawnFood();
        }
    }

    public boolean stepChecker(ArrayList<Coordinate> steps, int x, int y){
        for (Coordinate coordinate: steps){
            if (coordinate.getxCoordinate() == x && coordinate.getyCoordinate() == y){
                return true;
            }
        }
        return false;
    }

    public void removeDeathAnts(ArrayList<Ant> antColony){
        if (antColony.size() != 0){
            for (Ant ant: deathAnt){
                antColony.remove(ant);
            }
            deathAnt = new ArrayList<>();
        }
    }

}
