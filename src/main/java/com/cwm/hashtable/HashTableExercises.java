package com.cwm.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {

    public char firstNonRepeatedChar(String input) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = input.toCharArray();

        for (char c : chars)
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : chars)
            if (map.get(c) == 1)
                return c;

        return Character.MIN_VALUE;
    }

    public char firstRepeatedChar(String input) {
        Set<Character> set = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (set.contains(c))
                return c;

            set.add(c);
        }

        return Character.MIN_VALUE;
    }

    public int findMostFrequent(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array)
            map.put(i, map.getOrDefault(i, 0) + 1);

        int mostFrequent = 0;

        for (Integer key : map.keySet())
            if (map.get(key) > mostFrequent)
                mostFrequent = key;

        return mostFrequent;
    }

    public int countPairsWithDiff(int[] array, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i : array)
            set.add(i);

        int count = 0;

        for (int i : set)
            for (int j: set)
                if (j - i == k)
                    count++;

        return count;
    }

    public int[] twoSum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    set.add(i);
                    set.add(j);

                    int[] result = new int[set.size()];

                    int index = 0;

                    for (int k : set.stream().toList())
                        result[index++] = k;

                    return result;
                }
            }
        }

        return new int[0];
    }
}
