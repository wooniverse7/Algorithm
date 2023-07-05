package Programmers.S201_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    static class Booking {
        int time;
        String name;

        public Booking(int time, String name) {
            this.time = time;
            this.name = name;
        }
    }

    public static int parseTime(String t) {
        String[] parts = t.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return 60 * h + m;
    }

    public static String[] solution(String[][] booked, String[][] unbooked) {
        Booking[] bookedSlots = new Booking[booked.length + 1];
        for (int i = 0; i < booked.length; i++) {
            String t = booked[i][0];
            String name = booked[i][1];
            bookedSlots[i] = new Booking(parseTime(t), name);
        }
        bookedSlots[booked.length] = new Booking(1000000, null);

        Booking[] unbookedSlots = new Booking[unbooked.length + 1];
        for (int i = 0; i < unbooked.length; i++) {
            String t = unbooked[i][0];
            String name = unbooked[i][1];
            unbookedSlots[i] = new Booking(parseTime(t), name);
        }
        unbookedSlots[unbooked.length] = new Booking(1000000, null);

        Arrays.sort(bookedSlots, Comparator.comparingInt(b -> b.time));
        Arrays.sort(unbookedSlots, Comparator.comparingInt(u -> u.time));

        int b = 0, u = 0, t = 0;
        List<String> answerList = new ArrayList<>();

        while (b < bookedSlots.length && u < unbookedSlots.length) {
            int t1 = bookedSlots[b].time;
            int t2 = unbookedSlots[u].time;
            if (t1 <= t) {
                answerList.add(bookedSlots[b].name);
                b++;
                t += 10;
            } else if (t2 <= t) {
                answerList.add(unbookedSlots[u].name);
                u++;
                t += 10;
            } else {
                t = Math.min(t1, t2);
            }
        }

        answerList.remove(answerList.size() - 1);
        return answerList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] booked = {{"09:10", "lee"}};
        String[][] unbooked = {{"09:00", "kim"}, {"09:05", "bae"}};
        System.out.println(Arrays.toString(new Solution().solution(booked, unbooked))); // ["kim", "lee", "bae"]

        String[][] booked2 = {{"09:55", "hae"}, {"10:05", "jee"}};
        String[][] unbooked2 = {{"10:04", "hee"}, {"14:07", "eom"}};
        System.out.println(Arrays.toString(new Solution().solution(booked2, unbooked2))); // ["hae", "jee", "hee", "eom"]

    }
}
