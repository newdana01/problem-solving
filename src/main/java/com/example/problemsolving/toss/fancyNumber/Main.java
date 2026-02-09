package com.example.problemsolving.toss.fancyNumber;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("12223"));
        System.out.println(solution("111999333"));
        System.out.println(solution("123"));
        System.out.println(solution("111111"));
    }
    public static int solution(String s){
        int fancy = -1;

        for (int i=0; i<s.length()-2; i++){
            char num1 = s.charAt(i);
            char num2 = s.charAt(i+1);
            char num3 = s.charAt(i+2);

            if (num1 == num2 && num2 == num3){
                fancy = Math.max(fancy, Integer.parseInt(s.substring(i, i+3)));
            }
        }

        return fancy;
    }
}
