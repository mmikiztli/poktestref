package com.mmikitzli.poker;

import java.util.*;

public class PokerClient {

    private List<Card> myCards;
    private List<Card> opponentCards;

    public PokerClient(String card1, String card2, String card3, String card4, String card5) {
        myCards = Card.of(card1, card2, card3, card4, card5);
    }

    public boolean highestCardIsMine(String card1, String card2, String card3, String card4, String card5) {
        opponentCards = Card.of(card1, card2, card3, card4, card5);

        Card myMax = myCards.stream().max(Comparator.comparing(Card::getValue)).get();
        Card opponentMax = opponentCards.stream().max(Comparator.comparing(Card::getValue)).get();

        return myMax.getValue() >= opponentMax.getValue();
    }

}