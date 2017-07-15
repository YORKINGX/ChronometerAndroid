package com.administrador.chronometerandroid.model;

/**
 * Created by rony_2 on 15/5/2017.
 */

public class ChallengeIssued {

    Boolean aprobed;
    String challengeID;
    String created;
    String descrition;
    String name;
    int score;
    String userID;
    String videoURL;
    String challengeKey;
    int attemptsByUser;


    public Boolean getAprobed() {
        return aprobed;
    }

    public void setAprobed(Boolean aprobed) {
        this.aprobed = aprobed;
    }

    public String getChallengeID() {
        return challengeID;
    }

    public void setChallengeID(String challengeID) {
        this.challengeID = challengeID;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public void setChallengeKey(String challengeKey) {
        this.challengeKey = challengeKey;
    }

    public int getAttemptsByUser() {
        return attemptsByUser;
    }

    public void setAttemptsByUser(int attemptsByUser) {
        this.attemptsByUser = attemptsByUser;
    }

    public ChallengeIssued() {
    }

    public String getChallengeKey() {
        if(challengeKey == null)
            challengeKey = "";
        return challengeKey;
    }

    public ChallengeIssued(Boolean aprobed, String challengeID, String created, String descrition, String name, int score, String userID, String videoURL, String challengeKey, int attemptsByUser) {
        this.aprobed = aprobed;
        this.challengeID = challengeID;
        this.created = created;
        this.descrition = descrition;
        this.name = name;
        this.score = score;
        this.userID = userID;
        this.videoURL = videoURL;
        this.challengeKey = challengeKey;
        this.attemptsByUser = attemptsByUser;
    }


}
