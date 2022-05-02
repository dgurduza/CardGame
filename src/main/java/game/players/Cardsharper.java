package game.players;

import game.CardDeck;

import java.util.concurrent.TimeUnit;

/**
 * Класс, описывающий функции шулера.
 */
public class Cardsharper extends Player {
    HonestPlayer injuredPlayer;

    /**
     * Конструктор.
     *
     * @param name   имя шулера.
     * @param player объект честного игрока.
     */
    public Cardsharper(String name, HonestPlayer player) {
        super(name);
        injuredPlayer = player;
    }

    /**
     * Метод для игры в карты.
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                double likelihoodOfTheft = random.nextDouble();
                if (likelihoodOfTheft <= 0.4) {
                    playerBalance = playerBalance + injuredPlayer.stealPoints(random.nextInt(9));
                    TimeUnit.MILLISECONDS.sleep((random.nextInt(121) + 180));
                } else {
                    playerBalance += CardDeck.getCard();
                    TimeUnit.MILLISECONDS.sleep((random.nextInt(101) + 100));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
