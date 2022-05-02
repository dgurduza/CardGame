package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardDeckTest {
    @Test
    void getCardReturnNumberMoreThenZero() {
        assertTrue(CardDeck.getCard() > 0);
    }

    @Test
    void getCardReturnNumberLessThenTen() {
        assertTrue(CardDeck.getCard() <= 10);
    }
}
