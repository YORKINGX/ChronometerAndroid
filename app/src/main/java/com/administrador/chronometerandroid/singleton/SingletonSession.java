package com.administrador.chronometerandroid.singleton;

import com.administrador.chronometerandroid.model.BottleCode;
import com.administrador.chronometerandroid.model.Challenge;
import com.administrador.chronometerandroid.model.ChallengeIssued;
import com.administrador.chronometerandroid.model.Parameter;
import com.administrador.chronometerandroid.model.Score;
import com.administrador.chronometerandroid.model.User;

import java.util.ArrayList;


/**
 * Created by rony_2 on 16/12/2016.
 */

public class SingletonSession {

    private static SingletonSession instance;


    private String videoUri;
    ArrayList<Challenge> challenges;
    ArrayList<ChallengeIssued>myChallenges;
    private Score myScore;
    User user;
    BottleCode bottleCode;
    ArrayList<Parameter> parameters;



    //no outer class can initialize this class's object
    private SingletonSession() {
    }

    public static SingletonSession getInstance() {
        //if no instance is initialized yet then create new instance
        //else return stored instance
        if (instance == null) {
            instance = new SingletonSession();
        }
        return instance;
    }


    public BottleCode getBottleCode() {
        return bottleCode;
    }

    public void setBottleCode(BottleCode bottleCode) {
        this.bottleCode = bottleCode;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public ArrayList<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(ArrayList<Challenge> challenges) {
        this.challenges = challenges;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Score getMyScore() {
        return myScore;
    }

    public void setMyScore(Score myScore) {
        this.myScore = myScore;
    }

    public ArrayList<ChallengeIssued> getMyChallenges() {
        return myChallenges;
    }

    public void setMyChallenges(ArrayList<ChallengeIssued> myChallenges) {
        this.myChallenges = myChallenges;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }
}
