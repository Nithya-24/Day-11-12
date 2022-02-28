package deckOfCards;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Player> playersList = new ArrayList<>();
    public static DeckOfCards deckOfCards = new DeckOfCards();

    public static void main(String[] args) {
        deckOfCards.shuffleCards(deckOfCards.cards);
        Player.setPlayerNames();
        DeckOfCards.distributeCards();
        Player.printPlayerCards();
        Player.sortPlayerCards();
        Player.printPlayerCards();
    }
}