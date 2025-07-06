package com.example.furbetterorworse;

public class Raccoon {


    private String name; // printed label in UI/console
    private double aura;
    boolean isEnemy = false;
    boolean isLoveInterest = false;
    boolean RisAlive = true;


    public Raccoon(String name) {
        this(name, false, false);
        this.name = name;
        this.aura = 1.0;
    }


    public Raccoon(String name, double aura) {
        this(name, false, false);
        this.name = name;
        this.aura = aura;
    }


    public Raccoon(String name, boolean isEnemy, boolean isLoveInterest) {
        this.name = name;
        this.aura = 1;
        this.isEnemy = isEnemy;
        this.isLoveInterest = isLoveInterest;


    }


    public boolean isKO(){ //for when the enemies aura reachs 0
        return aura ==0 ;
    }


    /* Nice toString for debug / console printouts */
    @Override public String toString() {
        return name + " (" + aura + " aura)";
    }


    public static void setLoveInterest(boolean loveInterest){
    }


    //returns
    public String getName(){
        return name;
    }


    public double getAura(){
        return aura;
    }


    public void loseAura(double pts){
        aura = Math.max(aura-pts, 0);
    }


    public boolean noAura(){
        return aura == 0;
    }


    public void setRIsAlive(boolean alive){
        RisAlive = alive;
    }


    public boolean getRIsAlive() {
        return RisAlive;
    }
}

