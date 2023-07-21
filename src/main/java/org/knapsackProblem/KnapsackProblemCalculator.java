package org.knapsackProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Knapsack Calculator class that uses well-known algorithm to solve knapsack problem.
 * It first creates a grid with increasing values and then it calculates optimal results.
 */
public class KnapsackProblemCalculator {

    private static int[][] grid;
    private static final List<Integer> limits = new ArrayList<>();

    public static List<Item> calculateWhatShouldBeTaken(List<Item> items, int limit) {
        calculateLimits(limit);
        calculateGrid(items);
        return retrieveResults(items);
    }

    /**
     * fills static List limits with values needed to correctly calculate the grid
     *
     * @param limit
     */
    private static void calculateLimits(int limit) {
        for (int i = 0; i <= limit; i++) {
            limits.add(i);
        }
    }

    /**
     * calculates a grid that algorithm uses to find results
     *
     * @param items
     */
    private static void calculateGrid(List<Item> items) {

        grid = new int[items.size()][limits.size()];

        for (int i = 0; i < items.size(); i++) {
            for (int j = 1; j < limits.size(); j++) {
                if (i == 0) {
                    grid[i][j] = items.get(i).getTime() <= limits.get(j) ? items.get(i).getRating() : 0;
                    continue;
                }
                if (items.get(i).getTime() < limits.get(j)) {
                    grid[i][j] = Math.max(grid[i - 1][j], items.get(i).getRating() + grid[i - 1][limits.indexOf(limits.get(j) - items.get(i).getTime())]);
                    continue;
                }
                if (items.get(i).getTime() == limits.get(j)) {
                    grid[i][j] = Math.max(grid[i - 1][j], items.get(i).getRating());
                    continue;
                }
                grid[i][j] = grid[i - 1][j];
            }
        }
    }

    /**
     * it gets results from a grid and returns them as a List
     *
     * @param items
     * @return List<Item>
     */
    private static List<Item> retrieveResults(List<Item> items) {
        List<Item> selectedItems = new ArrayList<>();
        int i = items.size() - 1;
        int j = limits.size() - 1;

        while (i > 0) {
            if (grid[i][j] != grid[i - 1][j]) {
                selectedItems.add(items.get(i));
                j = limits.indexOf(limits.get(j) - items.get(i).getTime());
            }
            i--;
        }

        if (grid[i][j] > 0) {
            selectedItems.add(items.get(i));
        }

        return selectedItems;
    }
}
