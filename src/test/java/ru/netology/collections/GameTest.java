package ru.netology.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        game = new Game();
        player1 = new Player(1, "Malder", 56);
        player2 = new Player(2, "Hunt", 88);
        player3 = new Player(3, "Bond", 88);
    }

    @Test
    void register() {

        Player player = new Player(1, "Malder", 56);
        game.register(player);

        int expected = 1;
        int actual = game.findByName("Malder").getId();
        Assertions.assertEquals(expected, actual);
    }

    // должен возвращать 2, если сила игрока 1 меньше силы игрока 2
    @Test
    void shouldReturn2afterRound() {

        String player1Name = player1.getName();
        String player2Name = player2.getName();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player1Name, player2Name);
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturn1afterRound() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        String player1Name = player1.getName();
        String player2Name = player2.getName();

        int actual = game.round(player2Name, player1Name);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnZeroafterRound() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player2.getName(), player3.getName());
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowNotRegisteredException() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.findByName("Wayne");
        });
    }
}