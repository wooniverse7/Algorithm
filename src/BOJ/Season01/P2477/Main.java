package BOJ.Season01.P2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cham = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] length = new int[6]; // 변의 길이 저장

        // 최댓값 저장
        int widthMax = 0;
        int heightMax = 0;
        // 최대 길이 인덱스 저장
        int widIdx = -1;
        int hgtIdx = -1;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());

            // 긴 변 구하기
            if (dir[i] == 1 || dir[i] == 2) { // 가로변
                if (widthMax < length[i]) {
                    widthMax = length[i];
                    widIdx = i;
                }
            } else { // 세로변
                if (heightMax < length[i]) {
                    heightMax = length[i];
                    hgtIdx = i;
                }
            }
        }

        // 큰 사각형 넓이
        int bigSquare = widthMax * heightMax;
        // 가장 긴 변의 좌우는 작은 사각형의 변이 아니므로
        // 최대 길이 인덱스+3이 작은 사각형 가로, 세로의 길이이다. %6으로 모듈러 연산을 해준다.
        int smallSquare = length[(widIdx + 3) % 6] * length[(hgtIdx + 3) % 6];

        int rst = (bigSquare - smallSquare) * cham;
        System.out.println(rst);
    }
}
