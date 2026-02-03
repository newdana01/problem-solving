package com.example.problemsolving.programmers.privacy;

import java.util.*;

/*
- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/150370
- 시간복잡도: O(n+m) => terms 반복문 + privacies 반복문
*/
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> deleteList = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>(); // 약관과 유효기간을 적을 map
        int todayDay = getDays(today); // 오늘 날짜를 일수로 계산

        for(String t: terms){
            String[] split = t.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1])*28); // 약관과 유효기간을 일수로 저장
        }

        for(int i=0; i<privacies.length; i++){
            String[] split = privacies[i].split(" ");
            String date = split[0];
            String term = split[1];

            int endDay = getDays(date) + termMap.get(term); // 만료 날짜 계산

            if(endDay <= todayDay){ // 오늘 날짜보다 같거나 작으면 유효기간이 지난 것이므로 폐기
                deleteList.add(i+1);
            }
        }
        return deleteList.stream().mapToInt(x->x).toArray();
    }

    private int getDays(String date){ // "YYYY.MM.DD" 형태의 문자열 날짜를 일 수로 변환하는 함수
        int day = 0;
        String[] split = date.split("\\."); // .을 기준으로 split
        day += Integer.parseInt(split[2]);
        day += (Integer.parseInt(split[1]) -1) * 28; // 한달을 28로 가정 (문제 조건)
        day += (Integer.parseInt(split[0])-1) * 28 * 12;
        return day;
    }
}