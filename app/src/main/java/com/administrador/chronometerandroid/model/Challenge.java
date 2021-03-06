package com.administrador.chronometerandroid.model;

import java.util.HashMap;

/**
 * Created by rony_2 on 2/5/2017.
 */

public class Challenge {

    //List<TryUser> attemptsByUsers;
    //List<Rule> points;

    public HashMap<String,Rule> points;

    String challengeID;

    private String created;

    public String getCreated() { return this.created; }

    public void setCreated(String created) { this.created = created; }

    private String description;

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    private int level;

    public int getLevel() { return this.level; }

    public void setLevel(int level) { this.level = level; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private int score;

    public int getScore() { return this.score; }

    public void setScore(int score) { this.score = score; }

    private String videoURL;

    public String getVideoURL() { return this.videoURL; }

    public void setVideoURL(String videoURL) { this.videoURL = videoURL; }

    public HashMap<String, Rule> getPoints() {
        return points;
    }

    public void setPoints(HashMap<String, Rule> points) {
        this.points = points;
    }



    public Challenge() {
    }




    public String getChallengeID() {
        return challengeID;
    }

    public void setChallengeID(String challengeID) {
        this.challengeID = challengeID;
    }



    public Challenge(HashMap<String, Rule> points, String challengeID, String created, String description, int level, String name, int score, String videoURL) {

        this.points = points;
        this.challengeID = challengeID;
        this.created = created;
        this.description = description;
        this.level = level;
        this.name = name;
        this.score = score;
        this.videoURL = videoURL;
    }
}
