package BOJ.P2908;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next(); // 스페이스바 기준
        String b = sc.next();

        //reverse 문자열
        String ra = "";
        String rb = "";

        for (int i = 2; i >= 0; i--) {
            ra = ra + a.charAt(i);
            rb = rb + b.charAt(i);
        }

        int numa = Integer.parseInt(ra);
        int numb = Integer.parseInt(rb);

        System.out.println(Math.max(numa, numb));
    }
}
