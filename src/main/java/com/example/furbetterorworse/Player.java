package com.example.furbetterorworse;

public class Player {


    double  aura;
    boolean isAlive = true;


    public Player(){
        this.aura = 1.0;
    }


    //getters
    public double  getAura(){
        return aura;
    }


    public void resetAura(){
        aura = 1.0;
    }
    public void loseAura(float pts){
        aura = Math.max(aura-pts, 0);
    }
    public void gainAura(double  pts){
        aura = Math.min(aura+pts, 0);
    }


    public void setIsAlive(boolean alivey){
        isAlive = alivey;
    }


    public boolean getIsAlive(){
        return isAlive;
    }


    @Override public String toString() {
        return "You (" + aura + " aura)";
    }
}

