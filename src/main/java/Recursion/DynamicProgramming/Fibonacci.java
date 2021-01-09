package main.java.Recursion.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {


    private static int fibonacciRecursion(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        return fibonacciRecursion(x - 1) + fibonacciRecursion(x - 2);
    }

    private static int fibonacciMemoization(int n, Map<Integer, Integer> map) {
        if (!map.containsKey(n)) {
            map.put(n, fibonacciMemoization(n - 1, map) + fibonacciMemoization(n - 2, map));
        }
        return map.get(n);
    }

    private static int fibonacciTabulation(int n, Map<Integer, Integer> map) {
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacciRecursion(9));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
       // System.out.println(fibonacciMemoization(8, map));
        System.out.println(fibonacciTabulation(10, map));
    }
}
