package com.mmikitzli.poker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Card {

    private final String cardCode;
    private final String cardColor;
    private final String cardValue;
    private final int intCardValue;
    private final Map<String, Integer> alphabeticCardValue;
    private final List<String> colors = Arrays.asList("S","C","D","H");
    private final List<String> letterValues = Arrays.asList("J","Q","K","A");

    public Card(String cardCode) {
        this.cardCode = cardCode.toUpperCase();
        cardColor = this.cardCode.substring(0, 1);
        cardValue = this.cardCode.substring(1);

        alphabeticCardValue = IntStream.range(0, letterValues.size()).boxed()
                .collect(Collectors.toMap(letterValues::get, i -> i+11));

        check(colors.contains(cardColor),"card color isn't valid: " + cardColor);

        if (alphabeticCardValue.containsKey(cardValue)) {
            intCardValue = alphabeticCardValue.get(cardValue);
        } else {
            intCardValue = Integer.parseInt(cardValue);
            check(intCardValue >= 2 && intCardValue <= 10, "card number isn't valid: " + intCardValue);
        }
    }

    public static List<Card> of(String... cardCodes) {
        return Arrays.stream(cardCodes).map(Card::new).collect(Collectors.toList());
    }

    public int getValue() {
        return intCardValue;
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
