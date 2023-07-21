package org.knapsackProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * This program solves Knapsack Problem, therefore it returns item/s that are most valuable and fit within given range.
 * In hardcoded example there are 5 places in a town, which a traveler wants to visit. Each item has 2 parameters:
 * time needed to visit and traveler´s rating of the site.
 * But the traveler has only 6 hours to see the town.
 */
public class Main {
    public static void main(String[] args) {
        //Initializing input values
        int limit = 6;
        List<Item> items = new ArrayList<>();

        items.add(new Item("Main Square", 1, 10));
        items.add(new Item("Theater", 3, 6));
        items.add(new Item("Gallery", 3, 9));
        items.add(new Item("Museum", 2, 5));
        items.add(new Item("Cathedral", 1, 6));

        //Calculating
        List<Item> selectedItems = KnapsackProblemCalculator.calculateWhatShouldBeTaken(items, limit);

        //Printing results
        System.out.println("Item(s) that you should take:");
        selectedItems.forEach(System.out::println);
    }
}