package com.mmikitzli.poker;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by marti on 2017.05.22..
 */
public class CardTest {

    private Card card;

    @Test
    public void testIsCardColorWrong() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Card("W5");
        });
    }

    @Test
    public void testIsCardValueLarger() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Card("S11");
        });
    }

    @Test
    public void testIsCardValueSmaller() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Card("S1");
        });
    }

    @Test
    public void testIsCardValueNotValidLetter() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Card("SP");
        });
    }

    @Test
    public void testCardValuesAsLettersByGetValue() {
        char[] cardLetters = new char[] {'j','q','k','a'};
        List<Card> cards = new ArrayList<>();
        List<Integer> cardValues = new ArrayList<>();
        IntStream.range(0, 4).forEach(i ->cards.add(new Card("h" + cardLetters[i])));
        cards.stream().forEach(i -> cardValues.add(i.getValue()));
        List<Integer> result = Arrays.asList(11,12,13,14);
        assertEquals(result,cardValues);
    }

    @Test
    public void testGetValueWithLowerCase() {
        card = new Card("s5");
        assertEquals(5,card.getValue());
    }
}
