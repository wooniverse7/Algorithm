package BOJ.P1436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        int doom = 666;

        while(true){
            String str = String.valueOf(doom); // int -> String
            if(str.contains("666")) cnt++;

            if(cnt == N) {
                System.out.println(doom);
                break;
            }
            doom++;
        }
    }
}
