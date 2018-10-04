
package com.drinknplay.program;

import java.util.ArrayList;
import java.util.Scanner;

public class Execution {
    
    static Scanner userInput = new Scanner(System.in);
    static ArrayList<Game> gameList = new ArrayList<>();
    
    public static void main(String[] args){
        int menuChoice = 0;    
        String outputTextHeader = String.format("%-20s%-20s%-20s%-20s%-20s%-20s",
                    "Game ID","Game Name","Game rating","Game Time","Game Level","Game Equipment");


        do{

            System.out.println(
                "Game Menu\n" +
                "1. Add game\n" +
                "2. Display list of games\n" + 
                "3. Rate a game\n" +
                "4. Quit application\n\n" +
                "Selection: "
            );

                menuChoice = userInput.nextInt();
                if(menuChoice == 1)
                    addGame();
                else if(menuChoice == 2){
                    System.out.println(outputTextHeader);
                    displayGameList();
                    System.out.println();
                }
                else if(menuChoice == 3){
                    System.out.println(outputTextHeader);
                    rateGame();
                    System.out.println();
                }
                else
                    System.exit(0);

        } while(menuChoice != 4);
        System.exit(0);

    
    }
    
    public static void addGame(){
        
        String tempGameName = "Not Defined";
        int tempGameLevel = 0;
        int tempGameTime = 30;
        String tempGameDescription = "Not Defined";
        String tempGameInstruction = "Not Defined";
        
        userInput.nextLine();
        System.out.println("Name your game:");
        tempGameName = userInput.nextLine();
        
        while(tempGameLevel < 1 || tempGameLevel > 5)
        {
            System.out.println("Enter Gamelevel as 1-5 where 1 is easiest and 5 is hardest");
            tempGameLevel = userInput.nextInt();
        }
        
        System.out.println("Enter gametime as whole minutes (eg. 60");
        tempGameTime = userInput.nextInt();
        userInput.nextLine();
        
        System.out.println("Enter equipment needed to play " + tempGameName);
        tempGameDescription = userInput.nextLine();
        
        System.out.println("Enter instructions for playing " + tempGameName);
        tempGameInstruction = userInput.nextLine();
        
        Game tempNewGame = new Game(tempGameName,tempGameDescription,tempGameTime,tempGameLevel,tempGameInstruction);
        gameList.add(tempNewGame);
        System.out.println("Game " + tempGameName + " added.\n");
        
    }
    
    public static void displayGameList(){
            for(int i = 0; i < gameList.size(); i++){
            gameList.get(i).display();
        }
    }
    
    public static void rateGame(){
        for(int i = 0; i < gameList.size(); i++){
            gameList.get(i).display();
        }
        System.out.println("Enter Game ID of game you want to rate.");
        
        int choice = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Enter a rating of 1-5 where 1 is horrible and 5 is amazingly fun!");
        //int arrayPosition;
        int rating = userInput.nextInt();
        userInput.nextLine();
        for(int j = 0; j < gameList.size(); j++){
            if(gameList.get(j).getGameId() == choice){
                gameList.get(j).calculateGameRating(rating);
            }
        }
        System.out.println("Rating added. Thank you!\n");
        
    }
    
}
