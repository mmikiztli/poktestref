import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Card {

    private final String cardCode;
    private final String cardColor;
    private final String cardValue;
    private Integer intCardValue;
    private final HashMap<String, Integer> alphabeticCardValue;
    private final List<String> colors = Arrays.asList("S","C","D","H");
    private final List<String> letterValues = Arrays.asList("J","Q","K","A");

    public Card(String cardCode) {
        this.cardCode = cardCode.toUpperCase();
        cardColor = this.cardCode.substring(0, 1);
        cardValue = this.cardCode.substring(1);
        alphabeticCardValue = new HashMap<>();
        IntStream.range(0,4).forEach(i -> alphabeticCardValue.put(letterValues.get(i),i+11));


        if (!colors.contains(cardColor))
        {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }

        if (!alphabeticCardValue.containsKey(cardValue)) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            intCardValue = Integer.parseInt(cardValue);
            if (intCardValue > 10 || intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }

        }else{
            intCardValue = alphabeticCardValue.get(cardValue);
        }
    }

    public int getValue() {
        return intCardValue;
    }
}
