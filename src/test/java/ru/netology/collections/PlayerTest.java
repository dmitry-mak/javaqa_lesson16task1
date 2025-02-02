package ru.netology.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getId() {
        Player player = new Player(1,"Malder",56);
        int expected = 1;
        int actual = player.getId();
        assertEquals(expected, actual);
    }
}