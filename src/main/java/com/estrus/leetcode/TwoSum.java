package com.estrus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int p = target - nums[i];
            if (map.containsKey(p)){
                return new int[]{map.get(p),i};
            }
            map.put(nums[i],i);
        }

        return null;


    }
}
