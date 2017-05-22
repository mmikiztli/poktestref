import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by marti on 2017.05.22..
 */
public class PokerClientTest {

    private PokerClient pokerClient;

    @Test
    public void testHighestValueTrue() {
        pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertTrue(pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sj"));
    }

    @Test
    public void testHighestValueFalse() {
        pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertFalse(pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sk"));
    }

}
