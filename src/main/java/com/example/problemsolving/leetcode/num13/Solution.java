package com.example.problemsolving.leetcode.num13;

/*
* - 링크: https://leetcode.com/problems/roman-to-integer/
* - 성능: O(n)
* */
import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int N = s.length();
        // 심볼 저장
        Map<Character, Integer> symbolMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        for(int i=0; i< N; i++){
            char c = s.charAt(i);

            res += symbolMap.get(c);

            // subtraction 처리
            if(i > 0 && ((c == 'V' && s.charAt(i-1) == 'I') ||
                    (c == 'X' && s.charAt(i-1) == 'I'))
            ){
                res -= symbolMap.get('I') * 2;
            }else if (i > 0 && ((c == 'L' && s.charAt(i-1) == 'X') ||
                    (c == 'C' && s.charAt(i-1) == 'X'))
            ){
                res -= symbolMap.get('X') * 2;
            }else if (i > 0 && ((c == 'D' && s.charAt(i-1) == 'C') ||
                    (c == 'M' && s.charAt(i-1) == 'C'))
            ){
                res -= symbolMap.get('C') * 2;
            }
        }

        return res;
    }
}