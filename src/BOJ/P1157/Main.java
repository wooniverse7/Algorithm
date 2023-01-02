package BOJ.P1157;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        str = str.toUpperCase(); // 대문자 변환

        int[] abc = new int[26]; // 알파벳 카운트 배열

        for (int i = 0; i < str.length(); i++) {
            abc[str.charAt(i) - 'A']++; // 해당 문자의 idx 크기 1 증가
            // acbaae  abc[ 3 1 1 0 1 ... ]
        }

        int max = -1;
        char ch = '?';
        for (int i = 0; i < 26; i++) {
            if(abc[i] > max) {
                max = abc[i];
                ch = (char) (i + 65); // 아스키 코드 char로 형변환
            }else if(abc[i] == max) // 중간에 같은 것이 있더라도 마지막까지 탐색해서 제대로 된 답이 나옴
                // 3 1 2 2 3 1 2 1 4 2
                ch = '?';
        }

        System.out.println(ch);


    }
}
