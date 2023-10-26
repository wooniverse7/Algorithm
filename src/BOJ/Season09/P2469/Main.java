package BOJ.Season09.P2469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, k;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        char[] strChar = new char[k];
        for (int i = 0; i < k; i++) {
            strChar[i] = (char)('A' + i);
        }
        char[] endChar = br.readLine().toCharArray();

        map = new char[n][k-1];
        int lineIdx = 0; // ?가 나오는 행 저장
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();

            if(map[i][0] == '?')
                lineIdx = i;
        }

        // swap
        // 위에서 아래로
        for (int i = 0; i < lineIdx; i++) {
            for (int j = 0; j < k-1; j++) {
                if(map[i][j] == '-'){
                    char tmp = strChar[j];
                    strChar[j] = strChar[j+1];
                    strChar[j+1] = tmp;
                }
            }
        }

        // 아래에서 위로
        for (int i = n-1; i > lineIdx; i--) {
            for (int j = 0; j < k-1; j++) {
                if(map[i][j] == '-'){
                    char tmp = endChar[j];
                    endChar[j] = endChar[j+1];
                    endChar[j+1] = tmp;
                }
            }
        }

        for (int i = 0; i < k-1; i++) {
            if(strChar[i] == endChar[i]){
                sb.append("*");
            }else if(strChar[i] == endChar[i+1] || strChar[i+1] == endChar[i]){
                sb.append("-");
                char tmp = strChar[i];
                strChar[i] = strChar[i+1];
                strChar[i+1] = tmp;
            }else {
                for (int j = 0; j < k-1; j++) {
                    System.out.print("x");
                }
                System.out.println();

                return;
            }

        }

        System.out.println(sb);
    }
}

// ?를 기준으로 위에서 아래로 lineIdx - 1, 밑에서부터 lineIdx + 1까지 진행
// board가 '-'라면 스왑
// 한 줄이 비기때문에 위와 아래의 알파벳차이가 1개 까지만 나야한다.
// 위 아래가 같으면 '*', 한 개 차이면 '-'을 추가