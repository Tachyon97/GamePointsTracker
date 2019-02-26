package org.gamepointstracking.collections;

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
    public int getScore() {
        return points;
    }
    public void incrementScore() {
        points++;
    }
    public void decrementScore() {
        points--;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Player: " + user + " Points: " + getScore();
    }
}
