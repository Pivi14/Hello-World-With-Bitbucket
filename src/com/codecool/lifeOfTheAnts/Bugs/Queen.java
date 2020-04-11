package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Colony;
import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public class Queen extends Ant implements Move {
    private boolean eggHatching;
    private int eegHatch;
    private boolean mood;
    private int moodCounter;

    public boolean isEggHatching() {
        return eggHatching;
    }

    public void setEggHatching(boolean eggHatching) {
        this.eggHatching = eggHatching;
    }

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
                eggHatching = true;
            }
        }
    }

    @Override
    public void action(Colony colony) {
        move(colony);
    }
}
