package com.codecool.lifeOfTheAnts.Bugs;


public class Wasp extends Bug{
    private boolean live;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void waspWokenUp(){
        live = true;
        spawn();
    }
}
