package com.administrador.chronometerandroid.model;

/**
 * Created by Rony on 26/5/2017.
 */

public class ChallengeFreestyle {


    private String publicVideoURL;

    public String getPublicVideoURL() { return this.publicVideoURL; }

    public void setPublicVideoURL(String publicVideoURL) { this.publicVideoURL = publicVideoURL; }

    private String userID;

    public String getUserID() { return this.userID; }

    public void setUserID(String userID) { this.userID = userID; }

    private String videoURL;

    public String getVideoURL() { return this.videoURL; }

    public void setVideoURL(String videoURL) { this.videoURL = videoURL; }

    public ChallengeFreestyle( String publicVideoURL, String userID, String videoURL) {

        this.publicVideoURL = publicVideoURL;
        this.userID = userID;
        this.videoURL = videoURL;
    }

    public ChallengeFreestyle() {
    }
}
