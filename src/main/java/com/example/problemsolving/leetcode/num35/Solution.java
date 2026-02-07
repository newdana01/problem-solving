package com.example.problemsolving.leetcode.num35;


/*
- 링크: https://leetcode.com/problems/search-insert-position/description/
- 성능: O(n)
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

// 이진 탐색으로 푸는 법 : O(log n)

//class Solution {
//    public int searchInsert(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//
//        while (low <= high) {
//            // (low + high) / 2 시 발생할 수 있는 정수 오버플로우 방지
//            int mid = low + (high - low) / 2;
//
//            if (nums[mid] == target) {
//                return mid; // 타겟을 찾은 경우 해당 인덱스 반환
//            } else if (nums[mid] < target) {
//                low = mid + 1; // 타겟이 오른쪽에 있는 경우
//            } else {
//                high = mid - 1; // 타겟이 왼쪽에 있는 경우
//            }
//        }
//
//        // 타겟을 찾지 못한 경우, low는 타겟이 삽입되어야 할 적절한 위치를 가리킴
//        return low;
//    }
//}
