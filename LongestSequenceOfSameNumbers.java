package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestSequenceOfSameNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1,3,3,1,1,1,4,4,2,2,2,2,5,5,5,2,2,2,3

        int[] input = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        int end = 1;
        int currentStart = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] != input[i - 1]) {
                if (end - start < i - currentStart) {
                    start = currentStart;
                    end = i;
                }
                currentStart = i;
            }
        }

        if (input.length - currentStart > end - start) { // Checking the very last section
            start = currentStart;
            end = input.length;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (i == start) {
                System.out.println("The reoccurring number is: " + input[i]);
            }
            result.add(i);
        }

        result.stream()
                .map(integer -> "Index: " + integer)
                .forEach(System.out::println);
    }
}
