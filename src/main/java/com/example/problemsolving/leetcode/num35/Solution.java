package com.example.problemsolving.leetcode.num35;


/*
- 링크: https://leetcode.com/problems/search-insert-position/description/
- 성능: O(log n)
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int pointer = 0;
        while(pointer < nums.length){
            if (nums[pointer] == target){
                return pointer;
            }else if(nums[pointer] < target){
                pointer++;
            }else{
                return pointer--;
            }
        }
        return pointer;
    }

}