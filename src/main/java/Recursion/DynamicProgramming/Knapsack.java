package main.java.Recursion.DynamicProgramming;

public class Knapsack {


    private int noOfItems;
    private int knapsackCapacity;
    private int mostProfitValue;
    private int knapsackTable[][];
    private int[] weights;
    private int[] values;


    Knapsack(int noOfItems, int knapsackCapacity, int[] values, int[] weights) {
        this.noOfItems = noOfItems;
        this.knapsackCapacity = knapsackCapacity;
        this.values = values;
        this.weights = weights;
        this.knapsackTable = new int[noOfItems + 1][knapsackCapacity + 1];


    }

    private void solve() {
        for (int i = 1; i < noOfItems + 1; i++) {
            for (int w = 1; w < knapsackCapacity + 1; w++) {
                int itemsNotTaken = knapsackTable[i - 1][w];
                int itemsTaken = 0;

                if (weights[i] <= w) {
                    itemsTaken = values[i] + knapsackTable[i - 1][w - weights[i]];
                }
                knapsackTable[i][w] = Math.max(itemsNotTaken,itemsTaken);
            }


        }

        mostProfitValue = knapsackTable[noOfItems][knapsackCapacity];
    }


    private void showResults() {
        System.out.println("Most profit value is : " + mostProfitValue);
        for (int n = noOfItems, w = knapsackCapacity; n > 0; n--) {
            if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n - 1][w]) {
                System.out.println("Item taken : " + n);
                w = w - weights[n];
            }
        }
    }

    public static void main(String[] args) {

        int noOfItems = 3;
        int knapsackCapacity = 5;
        int values[] = new int[noOfItems + 1];
        values[1] = 10;
        values[2] = 4;
        values[3] = 7;
        int weights[] = new int[noOfItems + 1];
        weights[1] = 4;
        weights[2] = 2;
        weights[3] = 3;
        Knapsack knapsack = new Knapsack(noOfItems,knapsackCapacity,values,weights);
        knapsack.solve();
        knapsack.showResults();
    }
}
