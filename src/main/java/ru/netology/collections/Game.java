package ru.netology.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    private HashMap<String, Player> players;

    public Game() {
        this.players = new HashMap();
    }

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public Player findByName(String name) {
        Player player = players.get(name);
        if (player == null) {
            throw new NotRegisteredException("Игрок с именем \"" + name + "\" не найден");
        }
        return player;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
