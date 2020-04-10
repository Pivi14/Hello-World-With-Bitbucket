package com.codecool.lifeOfTheAnts;

import com.codecool.lifeOfTheAnts.Bugs.*;

import java.util.ArrayList;

public class Colony {
    private Wasp wasp = new Wasp();
    private ArrayList<Ant> antColony = new ArrayList<>();
    private ArrayList<Ant> deathAnt = new ArrayList<>();


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
        for (int i = 0; i < antColony.size(); i++){
            int beforeStepX = antColony.get(i).getX();
            int beforeStepY = antColony.get(i).getY();
            antColony.get(i).action(this);
            while (stepChecker(steps, antColony.get(i).getX(), antColony.get(i).getY())){
                antColony.get(i).setX(beforeStepX);
                antColony.get(i).setY(beforeStepY);
            }
            if (antColony.get(i).getLifeTime() > 0){
                steps.add(new Coordinate(antColony.get(i).getX(), antColony.get(i).getY()));
            } else {
                deathAnt.add(antColony.get(i));
            }
        }
        removeDeathAnts(antColony);
        if (RandomGenerate.randomGenerate(100, 0) <= 5 && !wasp.isLive()){
            wasp.waspWokenUp();
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
