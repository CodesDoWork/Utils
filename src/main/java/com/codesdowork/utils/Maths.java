package com.codesdowork.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Maths {

    public static List<int[]> generateCombinations(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        combinationHelper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    private static void combinationHelper(List<int[]> combinations, int[] data, int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            combinationHelper(combinations, data, start + 1, end, index + 1);
            combinationHelper(combinations, data, start + 1, end, index);
        }
    }
}
