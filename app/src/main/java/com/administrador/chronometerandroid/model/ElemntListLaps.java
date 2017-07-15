package com.administrador.chronometerandroid.model;

/**
 * Created by Administrador on 08/07/2017.
 */

public class ElemntListLaps {

    int numLaps;
    String Dscription;
    String Laps;

    public ElemntListLaps(int numLaps, String dscription, String laps) {
        this.numLaps = numLaps;
        Dscription = dscription;
        Laps = laps;
    }

    public ElemntListLaps() {
    }

    public int getNumLaps() {
        return numLaps;
    }

    public void setNumLaps(Integer numLaps) {
        this.numLaps = numLaps;
    }

    public String getDscription() {
        return Dscription;
    }

    public void setDscription(String dscription) {
        Dscription = dscription;
    }

    public String getLaps() {
        return Laps;
    }

    public void setLaps(String laps) {
        Laps = laps;
    }
}
