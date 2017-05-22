import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class PokerClient {

    private List<Card> myCards;
    private List<Card> opponentCards;


    public PokerClient(String card1, String card2, String card3, String card4, String card5) {
        myCards = new ArrayList<Card>();
        myCards.add(new Card(card1));
        myCards.add(new Card(card2));
        myCards.add(new Card(card3));
        myCards.add(new Card(card4));
        myCards.add(new Card(card5));



    }

    public boolean highestCardIsMine(String card1, String card2, String card3, String card4, String card5) {
        opponentCards = new ArrayList<Card>();
        opponentCards.add(new Card(card1));
        opponentCards.add(new Card(card2));
        opponentCards.add(new Card(card3));
        opponentCards.add(new Card(card4));
        opponentCards.add(new Card(card5));

        Card myMax = myCards.stream().max(Comparator.comparing(Card::getValue)).get();
        Card opponentMax = opponentCards.stream().max(Comparator.comparing(Card::getValue)).get();
        if(myMax.getValue() < opponentMax.getValue()) {
            return false;
        }else{
            return true;
        }

    }

}