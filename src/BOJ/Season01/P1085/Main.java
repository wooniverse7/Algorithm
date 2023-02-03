package BOJ.Season01.P1085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int aw = w-a;
        int bh = h-b;

        int[] arr = {a, b, aw, bh};
        int min = 2000;
        for (int i = 0; i < 4; i++) {
            if(arr[i] < min) min = arr[i];
        }
        System.out.println(min);
    }
}
