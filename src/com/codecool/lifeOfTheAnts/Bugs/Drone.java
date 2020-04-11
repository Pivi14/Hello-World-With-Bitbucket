package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Colony;
import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public class Drone extends Ant {
    private int moodCounter;
    {
        setLifeTime(RandomGenerate.randomGenerate(250, 150));
        setX(Main.getxOrigo());
        setY(Main.getyOrigo());
        setCubeX();
        setCubeY();
        while (isCubeX() && isCubeY()){
            setX(RandomGenerate.randomGenerate(Main.getxSize(), 0));
            setY(RandomGenerate.randomGenerate(Main.getySize(), 0));
            setCubeX();
            setCubeY();
        }
        setType("Drone");
        setDistanceFromQueen();
    }

    @Override
    public void move() {
        moveToward(Main.getxSize() / 2, Main.getySize() / 2);
    }

    @Override
    public void action(Colony colony) {
        Queen queen = (Queen) colony.getAntColony().get(0);
        if (!colony.getWasp().isLive()){
            if (getDistanceFromQueen() <= 3 && queen.getMoodCounter() <= 0 && !queen.isMood()){
                moodCounter = 3;
                queen.setMood(true);
                System.out.println("HALLELUJAH");
            } else if (moodCounter > 0){
                moodCounter--;
                if (moodCounter == 0){
                    queen.setEegHatch(3);
                    queen.setMood(false);
                    queen.setMoodCounter(RandomGenerate.randomGenerate(100, 75));
                    dropToCorner();
                }
            } else if (getDistanceFromQueen() > 3){
                move();
            }
            else {
                System.out.println("D'OH");
                dropToCorner();
            }
        }
        setDistanceFromQueen();
        setLifeTime(getLifeTime() - 1);
    }

    public void dropToCorner(){
        switch (RandomGenerate.randomGenerate(4, 0)){
            case 0:
                setX(0);
                setY(0);
                break;
            case 1:
                setX(Main.getxSize() - 1);
                setY(0);
                break;
            case 2:
                setX(0);
                setY(Main.getySize() - 1);
                break;
            case 3:
                setX(Main.getxSize() - 1);
                setY(Main.getySize() - 1);
                break;
        }
    }
}
