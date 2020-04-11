package com.codecool.lifeOfTheAnts;

import com.codecool.lifeOfTheAnts.Bugs.Bug;

public class Food extends Bug {
    private boolean carrying;
    private boolean spawn;

    public boolean isCarrying() {
        return !carrying;
    }

    public void setCarrying(boolean carrying) {
        this.carrying = carrying;
    }

    public boolean isSpawn() {
        return spawn;
    }

    public void setSpawn(boolean spawn) {
        this.spawn = spawn;
    }

    public void spawnFood(){
        spawn = true;
        spawn();
    }
}
