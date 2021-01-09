package main.java.Recursion;

public class Recursion {


    private static void headRecursion(int x) {
        if (x == 0) return;
        headRecursion(x - 1);
        System.out.print(x + " ");
    }

    private static void tailRecursion(int x) {

        if (x == 0) return;
        System.out.print(x + " ");
        tailRecursion(x - 1);
    }

    private static int addRecursive(int x) {
        if (x == 1) return 1;
        return x + addRecursive(x - 1);


    }

    private static int addIterative(int x) {

        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }

    private static int headFactorial(int x) {
        if (x == 0) return 1;
        return x * headFactorial(x - 1);
    }

    private static int tailFactorial(int x, int result) {
        if (x == 0) return result;
        return tailFactorial(x - 1, x * result);

    }

    private static int fibonacci(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = fibonacci(x - 1);
        int right = fibonacci(x - 1);
        return left + right;
    }

    private static int fibonacci_tail(int x, int a, int b) {
        if (x == 0) return a;
        if (x == 1) return b;
        return fibonacci_tail(x - 1, b, a + b);
    }

    private static int linearSearchRecursive(int[] arr, int key, int index) {

        if (index >= arr.length) return -1;

        if (arr[index] == key) return index;

        return linearSearchRecursive(arr, key, index + 1);
    }

    private static int binarySearchRecursive(int[] arr, int key, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == key) return mid;
        if (arr[mid] < key) {
            return binarySearchRecursive(arr, key, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, key, left, mid - 1);
        }

    }


    public static void main(String[] args) {

        // headRecursion(5);

        // tailRecursion(5);
        int[] arr = {1, 2, 3, 4, 5, 6,7,8,9,10};
        System.out.println("sum= " + binarySearchRecursive(arr,8,0,arr.length-1));
    }
}
