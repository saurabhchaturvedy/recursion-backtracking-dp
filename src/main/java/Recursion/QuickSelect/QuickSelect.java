package main.java.Recursion.QuickSelect;

import java.util.Random;

public class QuickSelect {

    static int[] container;

    QuickSelect() {

    }

    private int quickSelect(int first_index, int last_index, int k)  //  k = k-1 due to index starting at 0
    {
        int pivot_index = partition_array(first_index, last_index);
        if (pivot_index > k) {
            return quickSelect(first_index, pivot_index - 1, k);
        }
        if (pivot_index < k) {
            return quickSelect(pivot_index + 1, last_index, k);
        }
        return container[pivot_index];
    }

    private int partition_array(int first_index, int last_index) {

        int pivot = new Random().nextInt(last_index - first_index + 1) + first_index;
        swap(pivot, last_index);

        for (int i = first_index; i < last_index; i++) {
            if (container[i] > container[last_index])  // if Kth largest then '>' else '<'
            {
                swap(i, first_index);
                first_index++;
            }
        }

        swap(first_index, last_index);
        return first_index;
    }

    private void swap(int pivot, int last_index) {

        int temp = container[pivot];
        container[pivot] = container[last_index];
        container[last_index] = temp;
    }

    public static void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect();
        quickSelect.container = new int[]{1, -5, 10, 55, 2, 3, -7, 7, 11, 100};
        int element = quickSelect.quickSelect(0, container.length - 1, 1); // second largest
        System.out.println("element is = " + element);


    }
}
