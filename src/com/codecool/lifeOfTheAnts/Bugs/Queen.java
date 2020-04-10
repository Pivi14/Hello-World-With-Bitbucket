package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Colony;
import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public class Queen extends Ant implements Move {
    private String[] ants = {"Soldier", "Worker", "Drone"};
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
        setLifeTime(999);
        setX(Main.getxSize() / 2);
        setY(Main.getySize() / 2);
        moodCounter = 3;
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
                switch (ants[RandomGenerate.randomGenerate(ants.length, 0)]){
                    case "Soldier":
                        colony.getAntColony().add(new Soldier());
                        break;
                    case "Drone":
                        colony.getAntColony().add(new Drone());
                        break;
                    case "Worker":
                        colony.getAntColony().add(new Worker());
                        break;
                }
            }
        }
    }

    @Override
    public void action(Colony colony) {
        move(colony);
    }
}
