package deckOfCards;

import java.util.Scanner;

import static deckOfCards.Main.deckOfCards;
import static deckOfCards.Main.playersList;

public class Player {
    String[] cards = new String[]{};
    String name = "";

    public static int numberOfPlayers = 1;

    /*
    reads player name from user
     */
    public static void setPlayerNames(){
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= numberOfPlayers; i ++){
            Player player = new Player();
            System.out.print("Enter player "+i+" name: ");
            player.name = input.nextLine();
            playersList.add(player);
        }
        input.close();
    }
    /*
    Prints every player's cards separately
     */
    public static void printPlayerCards(){
        for(Player player: playersList){
            System.out.println(player.name + "'s deck have the following cards:");
            player.printCards(player.cards);
        }
    }

    public void printCards(String[] playerCards){
        for (String card: playerCards ) {
            System.out.println(card);
        }
    }

    /*
    sorts player the randomly distributed cards based on rank for all players in list
     */
   public static void sortPlayerCards(){

        for (Player player: playersList){
            player.cards =  deckOfCards.sortPlayerCards(player.cards);
            System.out.println("Sorted "+player.name+"'s cards.");
        }
   }

}