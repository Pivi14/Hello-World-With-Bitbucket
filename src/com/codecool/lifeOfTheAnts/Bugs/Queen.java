package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Colony;
import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public class Queen extends Ant implements Move {
    private int eegHatch;
    private boolean mood;
    private int moodCounter;

    public void setEegHatch(int eegHatch) {
        this.eegHatch = eegHatch;
    }

    public void setMood(boolean mood) {
        this.mood = mood;
    }

    public boolean isMood() {
        return mood;
    }

    public void setMoodCounter(int moodCounter) {
        this.moodCounter = moodCounter;
    }

    public int getMoodCounter() {
        return moodCounter;
    }

    {
        setLifeTime(1);
        setX(Main.getxSize() / 2);
        setY(Main.getySize() / 2);
        moodCounter = 50;
        setType("Queen");
    }

    @Override
    public void move(Colony colony) {
        if (moodCounter != 0){
            moodCounter--;
        }
        if (eegHatch != 0){
            eegHatch--;
            if (eegHatch == 0){
                int antHatch = RandomGenerate.randomGenerate(100, 0);
                if (antHatch < 20){
                    colony.getAntColony().add(new Soldier());
                } else if (antHatch > 80){
                    colony.getAntColony().add(new Drone());
                } else {


                    colony.getAntColony().add(new Worker());
                }
            }
        }
    }

    @Override
    public void action(Colony colony) {
        move(colony);
    }
}
