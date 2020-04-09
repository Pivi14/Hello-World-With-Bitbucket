package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public class Worker extends Ant {
    {
        setX(RandomGenerate.randomGenerate(Main.getxSize() - 10, 10));
        setY(RandomGenerate.randomGenerate(Main.getySize() - 10, 10));
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
}
