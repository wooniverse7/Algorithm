package Programmers.S201;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[][] booked = {{"09:10", "lee"}};
        String[][] unbooked = {{"09:00", "kim"}, {"09:05", "bae"}};
        System.out.println(Arrays.toString(new Solution().solution(booked, unbooked))); // ["kim", "lee", "bae"]

        String[][] booked2 = {{"09:55", "hae"}, {"10:05", "jee"}};
        String[][] unbooked2 = {{"10:04", "hee"}, {"14:07", "eom"}};
        System.out.println(Arrays.toString(new Solution().solution(booked2, unbooked2))); // ["hae", "jee", "hee", "eom"]
    }

    public String[] solution(String[][] booked, String[][] unbooked) {
        String[] answer = {};



        return answer;
    }
}

class Customer {
    final int arrivedAt;
    final String name;

    Customer(int arrivedAt, String name) {
        this.arrivedAt = arrivedAt;
        this.name = name;
    }

    private int parseTime(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}