package com.administrador.chronometerandroid.model;

/**
 * Created by rony_2 on 2/5/2017.
 */

public class Score {
    String displayName;
    int level;
    int score;
    String userID;

    public Score() {
    }

    public Score(String displayName, int level, int score, String userID) {
        this.displayName = displayName;
        this.level = level;
        this.score = score;
        this.userID = userID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
}
