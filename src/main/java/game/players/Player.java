package game.players;

import java.util.Random;

/**
 * Абстрактный класс, описывающий игрока.
 */
public abstract class Player extends Thread {
    protected int playerBalance;
    protected String playerName;
    protected Random random = new Random();

    /**
     * Констурктор класса.
     *
     * @param name имя игрока.
     */
    public Player(String name) {
        playerName = name;
        playerBalance = 0;
    }

    /**
     * Получение имени игрока.
     *
     * @return имя игрока.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Получение баланса игрока.
     *
     * @return баланс игрока.
     */
    public int getPlayerBalance() {
        return playerBalance;
    }
}

