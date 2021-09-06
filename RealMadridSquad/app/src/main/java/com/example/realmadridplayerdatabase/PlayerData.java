package com.example.realmadridplayerdatabase;

public class PlayerData {
    private String playerName;
    private String playerPosition;
    private String playerBirthDate;
    private String playerBirthPlace;
    private String playerHeight;
    private String playerDescription;
    private String playerCountry;
    private String playerImage;

    public PlayerData(String playerName, String playerPosition, String playerBirthDate, String playerBirthPlace, String playerHeight, String playerDescription, String playerCountry, String playerImage) {
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerBirthDate = playerBirthDate;
        this.playerBirthPlace = playerBirthPlace;
        this.playerHeight = playerHeight;
        this.playerDescription = playerDescription;
        this.playerCountry = playerCountry;
        this.playerImage = playerImage;
    }

    public PlayerData(){}

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public String getPlayerBirthDate() {
        return playerBirthDate;
    }

    public String getPlayerBirthPlace() {
        return playerBirthPlace;
    }

    public String getPlayerHeight() {
        return playerHeight;
    }

    public String getPlayerDescription() {
        return playerDescription;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public String getPlayerImage() {
        return playerImage;
    }
}