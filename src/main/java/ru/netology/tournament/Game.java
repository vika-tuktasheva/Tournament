package ru.netology.tournament;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> players = new ArrayList<>();

    //конструкторы
    public Game() {
    }

    public Game(Collection<Player> players) {
        this.players = players;
    }

    //getter and setter

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    //методы
    //добавление зарегистрированного игрока
    public void register(Player player) {
        players.add(player);
    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        int strengthPlayer1 = strengthFound(playerName1);
        int strengthPlayer2 = strengthFound(playerName2);
        //если хотя бы один из игроков не зарегистрирован - выкидываем исключение
        if (strengthPlayer1 == 0) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован!");
        }
        if (strengthPlayer2 == 0) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован!");
        }
        //сравниваем силу игроков
        if (strengthPlayer1 > strengthPlayer2) {//победа первого игрока
            return 1;
        }
        if (strengthPlayer1 < strengthPlayer2) {//победа второго игрока
            return 2;
        }
        return 0;//ничья
    }

    //поиск силы игроков
    public int strengthFound(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                int strengthPlayer = player.getStrength();
                return strengthPlayer;
            }
        }
        return 0;//в случае, когда игрок не зарегистрирован
    }
}
