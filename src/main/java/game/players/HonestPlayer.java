package game.players;

import game.CardDeck;

import java.util.concurrent.TimeUnit;

/**
 * Класс, описывающий функции честного игрока.
 */
public class HonestPlayer extends Player {
    /**
     * Констурктор.
     *
     * @param name имя честного игрока.
     */
    public HonestPlayer(String name) {
        super(name);
    }

    /**
     * Метод для игры честного игрока.
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                playerBalance += CardDeck.getCard();
                TimeUnit.MILLISECONDS.sleep((random.nextInt(101) + 100));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Метод для воровства баллов у честного игрока.
     *
     * @param pointsForTheft количество баллов, которые хотят украсть.
     * @return сворованные баллы.
     */
    public int stealPoints(int pointsForTheft) {
        synchronized (this) {
            if (this.playerBalance > 0) {
                if (pointsForTheft > this.playerBalance) {
                    int points = this.playerBalance;
                    this.playerBalance = 0;
                    return points;
                } else {
                    this.playerBalance = this.playerBalance - pointsForTheft;
                    return pointsForTheft;
                }
            }
            return 0;
        }
    }
}

