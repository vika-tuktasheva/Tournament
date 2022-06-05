package ru.netology.tournament;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldPlayerOneWin() {//победил первый игрок
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 150);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Petya", "Vasya");
        assertEquals(expected, actual);
    }

    @Test
    void shouldPlayerTwoWin() {//победил второй игрок
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 50);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Petya", "Vasya");
        assertEquals(expected, actual);
    }

    @Test
    void shouldDrawCase() {//ничья
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 100);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Petya", "Vasya");
        assertEquals(expected, actual);
    }

    @Test
    void shouldPlayerTwoUnregistered() {//один из игроков не зарегистрирован
        Game game = new Game();
        Player player1 = new Player(1, "Petya", 100);
        game.register(player1);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Vasya");
        });
    }

    @Test
    void shouldPlayerOneUnregistered() {//один из игроков не зарегистрирован
        Game game = new Game();
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Vasya");
        });
    }
}