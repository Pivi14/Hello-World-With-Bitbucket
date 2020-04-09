package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Main;

public class Queen extends Ant{
    private boolean mood;
    private int moodCounter;

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
        setX(Main.getxSize() / 2);
        setY(Main.getySize() / 2);
        moodCounter = 50;
        setType("Queen");
    }

    @Override
    public void move() {
        if (moodCounter != 0){
            moodCounter--;
        }
    }
}
