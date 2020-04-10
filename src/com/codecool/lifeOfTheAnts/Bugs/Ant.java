package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Colony;
import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public abstract class Ant extends Bug {
    private int lifeTime;
    private int distanceFromQueen;

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public int getDistanceFromQueen() {
        return distanceFromQueen;
    }

    public void setDistanceFromQueen() {
        this.distanceFromQueen = distanceCounter(Main.getxSize() / 2, Main.getySize() / 2, getX(), getY());
    }

    public void move() {
    }


    public void action(Colony colony) {
        if (!colony.getWasp().isLive()) {
            move();
        }
        setDistanceFromQueen();
        lifeTime--;
    }

    public int distanceCounter(int targetX, int targetY, int X, int Y) {
        return (Math.abs(targetX - X) + Math.abs(targetY - Y));
    }

    public void moveToward(int targetX, int targetY) {
        int distanceFromTarget = distanceCounter(targetX, targetY, getX(), getY());
        int newDistanceFromTarget = distanceFromTarget;
        while (distanceFromTarget == newDistanceFromTarget) {
            if (RandomGenerate.randomGenerate(2, 0) == 1) {
                if (getX() > targetX) {
                    setX(getX() - 1);
                } else if (getX() < targetX) {
                    setX(getX() + 1);
                }
            } else {
                if (getY() > targetY) {
                    setY(getY() - 1);
                } else if (getY() < targetY) {
                    setY(getY() + 1);
                }
            }
            newDistanceFromTarget = distanceCounter(targetX, targetY, getX(), getY());
        }
    }
}
