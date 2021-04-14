package com.company;

import java.util.*;


public class Solution { }

class RandomizedSet {

    Map<Integer,Integer> randomMap;
    List<Integer> randomValues;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.randomMap = new HashMap<>();
        this.randomValues = new LinkedList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    // Overall time complexity: O(1) time
    public boolean insert(int val) {
        if (!randomMap.containsKey(val)) {
            randomMap.put(randomValues.size(), val);
            randomValues.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // Overall time complexity: O(1) time
    public boolean remove(int val) {
        if (randomMap.containsKey(val)) {
            // getting all the values will be in O(1) time
            int lastIndex = randomValues.size() - 1;
            int valueInLastIndex = randomValues.get(lastIndex);
            int givenIndex = randomMap.get(val);

            // swapping the given value to the last index value // O(1) time
            randomMap.put(val, lastIndex);
            randomValues.set(lastIndex, val);
            randomMap.put(givenIndex, valueInLastIndex);
            randomValues.set(givenIndex, valueInLastIndex);

            // remove the last index // O(1) time
            randomMap.remove(val);
            randomValues.remove(lastIndex);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomValuesLength = randomValues.size();
        int randomizedIndex =  (int) (Math.random() * randomValuesLength);

        if (randomizedIndex > randomValuesLength)
            return randomValues.get(randomValuesLength - 1);

        return randomValues.get(randomizedIndex);
    }
}
