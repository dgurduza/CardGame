package game;

import java.util.Random;

/**
 * Класс для получения карты.
 */
public class CardDeck {
    private static final Random random;

    static {
        random = new Random();
    }

    /**
     * Единоличное лучение карты.
     *
     * @return номинал карты.
     */
    public synchronized static int getCard() {
        return random.nextInt(10) + 1;
    }
}
