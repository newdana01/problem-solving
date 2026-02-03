package com.example.problemsolving.programmers.present;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>(); // 선물을 준 기록을 담는 map
        HashMap<String, Integer> giftIdx = new HashMap<>(); // 선물 지수 map

        for(int i=0; i < friends.length; i++){ // 이름을 key로 넣어주기
            map.put(friends[i], new HashMap<String, Integer>());
            giftIdx.put(friends[i], 0);
        }

        for (int i=0; i<gifts.length; i++){
            String[] split = gifts[i].split(" ");
            String giver = split[0];
            String taker = split[1];
            HashMap<String, Integer> logMap = map.get(giver);

            logMap.put(taker, logMap.getOrDefault(taker, 1) +1); // 준 사람과 준 선물 개수 저장

            giftIdx.put(giver, giftIdx.get(giver)+1); // 선물 인덱스 계산: 선물을 준 사람은 지수 +1
            giftIdx.put(taker, giftIdx.get(taker)-1); // 선물 인덱스 계산: 선물을 받은 사람은 지수 -1
        }

        for(int i =0; i<friends.length; i++){
            String giver = friends[i];
            HashMap<String, Integer> logMap = map.getOrDefault(giver, new HashMap<String, Integer>());
            int count = 0; // 받을 선물 개수

            for (int j=0; j<friends.length; j++){ // 최종적으로 받을 선물 계산
                String taker = friends[j];
                if(giver.equals(taker)) continue; // 자신의 이름이면 건너뛰기

                int giverGift = getGiftCount(taker, logMap); // giver -> taker 준 선물 개수
                int takerGift = getGiftCount(giver, map.get(taker)); // taker -> giver 준 선물 개수

                if (giverGift > takerGift) count++; // giver가 준 선물이 더 많으면 count+1
                else if (giverGift == takerGift && // 주고 받은 선물 개수가 같고
                        giftIdx.get(giver) > giftIdx.get(taker)){ // giver의 선물 지수가 더 크다면 count +1
                    count++;
                }
            }
            answer = Math.max(answer, count); // 받을 선물의 최댓값 저장
        }
        return answer;
    }

    private int getGiftCount(String name, HashMap<String, Integer> map){
        if(!map.containsKey(name)) return 0; // 선물을 준 기록이 없다면 0 반환
        return map.get(name);
    }
}
