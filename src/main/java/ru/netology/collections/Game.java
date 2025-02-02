package ru.netology.collections;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player p : players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new NotRegisteredException("Игрок с именем \"" + name + "\" не найден");
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
