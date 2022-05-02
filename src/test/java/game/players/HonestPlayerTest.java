package game.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HonestPlayerTest {
    @Test
    void stealPointsReturnNumber() {
        Cardsharper ch = new Cardsharper("Name", new HonestPlayer("Name1"));
        assertTrue(ch.injuredPlayer.stealPoints(1) >= 0);
    }
}
