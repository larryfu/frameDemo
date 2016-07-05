package cn.larry;

import java.util.Random;

/**
 * Created by larryfu on 2016/2/28.
 *
 * @author larryfu
 */
public class QuickSort {


    private static void sort(int[] numbers, int start, int end) {
        if (start < 0 || end >= numbers.length)
            throw new IllegalArgumentException();
        if (start >= end)
            return;
        int j = partition(start, end, numbers);
        sort(numbers, start, j - 1);
        sort(numbers, j + 1, end);
    }

    private static int partition(int start, int end, int[] numbers) {
        int tag = numbers[start];
        int i = start + 1, j = end;
        while (true) {
            while (numbers[i] <= tag && i < end) i++;
            while (numbers[j] >= tag && j > start) j--;
            if (i >= j) break;
            swap(numbers, i, j);
        }
        swap(numbers, start, j);
        return j;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++)
            numbers[i] = random.nextInt(1000);
        sort(numbers, 0, numbers.length - 1);
        for (int i : numbers) {
            System.out.print(i + ",");
        }

    }

}
