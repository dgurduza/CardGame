package game.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    void getHonestPlayerName() {
        Player player = new HonestPlayer("Name");
        assertTrue(player.getPlayerName() == "Name");
    }

    @Test
    void getHonestPlayerBalance() {
        Player player = new HonestPlayer("Name");
        assertTrue(player.getPlayerBalance() == 0);
    }

    @Test
    void getCardsharperName() {
        Player player = new Cardsharper("Name", new HonestPlayer("Name1"));
        assertTrue(player.getPlayerName() == "Name");
    }

    @Test
    void getCardsharperBalance() {
        Player player = new Cardsharper("Name", new HonestPlayer("Name1"));
        assertTrue(player.getPlayerBalance() == 0);
    }
}
