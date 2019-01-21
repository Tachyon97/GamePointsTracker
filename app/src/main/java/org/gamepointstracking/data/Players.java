package org.gamepointstracking.data;

public class Players {
    int points;
    String user;

    public Players(String player) {
        user = player;
    }

    public void setUser(String name) {
        user = name;
    }
    public String getUser() {
        return user;
    }
    public void incrementScore() {
        points++;
    }
    public void decrementScore() {
        points--;
    }
    public void customScore(int score) {
        points += score;
    }
}
