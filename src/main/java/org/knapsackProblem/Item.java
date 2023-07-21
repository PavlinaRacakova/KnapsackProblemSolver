package org.knapsackProblem;

public class Item {

    String name;
    private final int time;
    private final int rating;

    public Item(String name, int time, int rating) {
        this.name = name;
        this.time = time;
        this.rating = rating;
    }

    public int getTime() {
        return time;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return name;
    }
}
