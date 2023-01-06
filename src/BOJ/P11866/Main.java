package BOJ.P11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            int tmp = m*i; // 3 6 9-7 12-7 15-7-7
            while(tmp >= n){
                tmp -= 7;
            }
            q.add(tmp);
        }
        String str = q.toString();
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, '<');
        sb.setCharAt(sb.length()-1, '>');

        System.out.println(sb);

    }
}
