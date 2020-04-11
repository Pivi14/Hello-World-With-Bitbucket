package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Colony;
import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public class Worker extends Ant {
    private boolean carrying;

    {
        setLifeTime(RandomGenerate.randomGenerate(250, 150));
        setX(Main.getxOrigo());
        setY(Main.getyOrigo());
        setCubeX();
        setCubeY();
        while (isCubeX() && isCubeY()){
            setX(RandomGenerate.randomGenerate(Main.getxSize() - 5, 5));
            setY(RandomGenerate.randomGenerate(Main.getySize() - 5, 5));
            setCubeX();
            setCubeY();
        }
        setType("Worker");
        setDistanceFromQueen();
    }

    @Override
    public void move() {
        int newDistanceFromQueen = getDistanceFromQueen();
        while (newDistanceFromQueen == getDistanceFromQueen()){
            switch (RandomGenerate.randomGenerate(4, 0)){
                case 0:
                    if (getX() > 0){
                        setX(getX() - 1);
                    }
                    break;
                case 1:
                    if (getY() < Main.getySize() - 1){
                        setY(getY() + 1);
                    }
                    break;
                case 2:
                    if (getX() < Main.getxSize() - 1){
                        setX(getX() + 1);
                    }
                    break;
                case 3:
                    if (getY() > 0){
                        setY(getY() - 1);
                    }
                    break;
            }
            newDistanceFromQueen = distanceCounter(Main.getxSize() / 2, Main.getySize() / 2, getX(), getY());
        }
    }

    @Override
    public void action(Colony colony) {
        Queen queen = (Queen) colony.getAntColony().get(0);
        if (colony.getFood().isSpawn() && colony.getFood().isCarrying() && !colony.getWasp().isLive()){
            moveToward(colony.getFood().getX(), colony.getFood().getY());
            if (distanceCounter(colony.getFood().getX(), colony.getFood().getY(), getX(), getY()) <= 1){
                colony.getFood().setCarrying(true);
                carrying = true;
            }
        } else if (carrying && !colony.getWasp().isLive()){
            moveToward(queen.getX(), queen.getY());
            colony.getFood().setX(getX());
            colony.getFood().setY(getY());
            if (getDistanceFromQueen() <= 2){
                queen.setMoodCounter(queen.getMoodCounter() - 5);
                colony.getFood().setCarrying(false);
                colony.getFood().setSpawn(false);
                carrying = false;
            }
        } else if (!colony.getWasp().isLive()){
            move();
        } else if (getLifeTime() <= 1){
            carrying = false;
            colony.getFood().setCarrying(false);
        }
        setLifeTime(getLifeTime() - 1);
        setDistanceFromQueen();
    }
}
