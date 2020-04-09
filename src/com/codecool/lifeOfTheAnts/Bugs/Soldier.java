package com.codecool.lifeOfTheAnts.Bugs;

import java.util.ArrayList;
import java.util.Arrays;

import com.codecool.lifeOfTheAnts.Colony;
import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public class Soldier extends Ant {
    private ArrayList<String> patrol = new ArrayList<>(Arrays.asList("North", "East", "South", "West"));

    {
        setX(RandomGenerate.randomGenerate(Main.getxSize() - 10, 10));
        setY(RandomGenerate.randomGenerate(Main.getySize() - 10, 10));
        setType("Soldier");
        setDistanceFromQueen();
    }

    @Override
    public void move() {
        switch (patrol.get(0)){
            case "North":
                setX(getX() - 1);
                break;
            case "East":
                setY(getY() + 1);
                break;
            case "South":
                setX(getX() + 1);
                break;
            case "West":
                setY(getY() - 1);
                break;
        }
        setDistanceFromQueen();
        patrol.add(patrol.get(0));
        patrol.remove(0);
    }

    @Override
    public void action(Colony colony) {
        Wasp wasp = colony.getWasp();
        if (wasp.isLive()){
            moveToward(wasp.getX(), wasp.getY());
            if (distanceCounter(wasp.getX(), wasp.getY(), getX(), getY()) <= 1){
                System.out.println("HAJIME");
                wasp.setLive(false);
            }
        } else {
            move();
        }
        setDistanceFromQueen();
    }


}
