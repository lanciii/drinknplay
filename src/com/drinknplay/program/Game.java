
package com.drinknplay.program;


public class Game {
    private static int gameIndex = 1;
    private int gameId;
    private String gameName;
    private String gameEquipment;
    private int gameTime;
    private int gameDifficulty;
    private String gameInstruction;
    private double gameRating = 0;
    private int gameRatingTotal = 0;
    private int gameNumberOfVotes = 0;
    
    public Game(String name, String equip, int time, int level, String instr){
        
        gameId = gameIndex;
        gameIndex++;
        gameName = name;
        gameEquipment = equip;
        gameTime = time;
        gameDifficulty = level;
        gameInstruction = instr;
    }
    
    public void display(){

        String outputTextValues = String.format("%-20d%-20s%-20.2f%-20d%-20d%-20s",
                gameId,gameName,gameRating,gameTime,gameDifficulty,gameEquipment);
        System.out.println(outputTextValues);
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameEquipment() {
        return gameEquipment;
    }

    public int getGameTime() {
        return gameTime;
    }

    public int getGameDifficulty() {
        return gameDifficulty;
    }
    
    public String getGameInstruction(){
        return gameInstruction;
    }

    public static int getGameIndex() {
        return gameIndex;
    }

    public double getGameRating() {
        return gameRating;
    }

    public int getGameRatingTotal() {
        return gameRatingTotal;
    }

    public int getGameNumberOfVotes() {
        return gameNumberOfVotes;
    }

    public void setGameRating(int gameRating) {
        this.gameRating = gameRating;   
    }
    
    public void calculateGameRating(int rating){
        ++gameNumberOfVotes;
        System.out.println(gameNumberOfVotes);
        setGameRating((gameRatingTotal += rating) / gameNumberOfVotes);  
    }
    
    
}
