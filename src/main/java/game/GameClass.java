package game;

import game.players.Cardsharper;
import game.players.HonestPlayer;
import game.players.Player;

/**
 * Класс, описывающий игровой процесс.
 */
public class GameClass {
    private HonestPlayer honestPlayer;
    private Cardsharper firstThief;
    private Cardsharper secondThief;

    /**
     * Создание игры.
     */
    public GameClass() {
        honestPlayer = new HonestPlayer("Ваня");
        firstThief = new Cardsharper("Петя", honestPlayer);
        secondThief = new Cardsharper("Коля", honestPlayer);
    }

    /**
     * Объявление о начале игры, запуск игроков.
     */
    public void startPlayers() {
        honestPlayer.start();
        firstThief.start();
        secondThief.start();
        System.out.println("Start game!");
    }

    /**
     * Конец игрового процесса.
     */
    public void stopPlayers() {
        secondThief.interrupt();
        firstThief.interrupt();
        honestPlayer.interrupt();
        System.out.println("Stop game!");
        getWinner();
    }

    /**
     * Вывод победителя.
     */
    private void getWinner() {
        int maxBalance = 0;
        String winnerName = "";
        String secondWinner = "";
        Player[] players = new Player[3];
        players[0] = honestPlayer;
        players[1] = firstThief;
        players[2] = secondThief;
        for (int i = 0; i < 3; ++i) {
            if (players[i].getPlayerBalance() > maxBalance) {
                maxBalance = players[i].getPlayerBalance();
                winnerName = players[i].getPlayerName();
            } else if (players[i].getPlayerBalance() == maxBalance) {
                secondWinner = players[i].getPlayerName();
            }
        }
        if (!secondWinner.equals("")) {
            System.out.println("Winner: " + winnerName);
            System.out.println("Second Winner: " + secondWinner + "\nBalance: " + maxBalance);
        } else {
            System.out.println("Winner: " + winnerName + "\nBalance: " + maxBalance);
        }
        System.out.println("Список игроков с балансами:");
        System.out.println(honestPlayer.getPlayerName() + " Balance: " + honestPlayer.getPlayerBalance());
        System.out.println(firstThief.getPlayerName() + " Balance: " + firstThief.getPlayerBalance());
        System.out.println(secondThief.getPlayerName() + " Balance: " + secondThief.getPlayerBalance());
    }
}
