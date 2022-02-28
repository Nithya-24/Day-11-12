package deckOfCards;

import java.util.Random;

import static deckOfCards.Main.*;

public class DeckOfCards {

    String[] suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String[] cards = new String[]{};

    public static int numberOfCardsToEach = 9;
    /*
    constructor creates a deckOfCards object with string array of 52 cards in it.
     */
    DeckOfCards(){
        for (String suit : suits) {
            for (String rank : ranks) {
                cards = addCardToDeck(cards, rank + " " + suit);
            }
        }
    }
    /*
    Function creates the deck of cards by matching suits and ranks
     */
    public static String[] addCardToDeck(String[] cardsArray, String newCard){
        String[] newCardsArray = new String[cardsArray.length + 1];
        if (cardsArray.length != 0) {
            System.arraycopy(cardsArray, 0, newCardsArray, 0, cardsArray.length);
            newCardsArray[cardsArray.length] = newCard;
        } else {
            newCardsArray[0] = newCard;
        }
        return newCardsArray;
    }

    /*
    Shuffles the cards using random object
     */
    void shuffleCards(String[] cardsArray){
        Random rand = new Random();
        for (int i = 0; i < cardsArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(cardsArray.length);
            String temp = cardsArray[randomIndexToSwap];
            cardsArray[randomIndexToSwap] = cardsArray[i];
            cardsArray[i] = temp;
        }
    }
    /*
    Distribute cards to individual players to their deck
     */
    public static void distributeCards(){
        int cardsIndex = 0;
        for(Player player: playersList){
            for (int i = 0; i < numberOfCardsToEach; i++) {
                player.cards = DeckOfCards.addCardToDeck(player.cards, deckOfCards.cards[cardsIndex]);
                cardsIndex++;
            }
        }
    }
    /*
    Sort player cards based on ranks and returns to player deck
     */
    String[] sortPlayerCards(String[] cards){
        String[] sortedCardsArray = new String[cards.length];
        int cardIndex = 0;
        for (String rank : ranks) {
            for (String card : cards) {
                if (card.contains(rank)) {
                    sortedCardsArray[cardIndex] = card;
                    cardIndex++;
                }
            }
        }
        return sortedCardsArray;
    }

}