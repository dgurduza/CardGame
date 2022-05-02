package game;

import java.util.Scanner;

import static java.lang.Thread.currentThread;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        String command;
        do {
            GameClass game = new GameClass();
            // Старт игры.
            game.startPlayers();
            // Время продолжения игры.
            currentThread().sleep(10000);
            // Конец игры.
            game.stopPlayers();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Для повтора игры введи 1, для выхода все любой символ");
            command = scanner.next();
        } while (command.equals("1"));
    }
}
