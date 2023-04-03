package BOJ.Season03.P1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int[] switches = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine()); // 학생 수
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            // 남자
            if(gender == 1) {
                for (int j = 0; j < total; j++) {
                    if((j+1) % number == 0) switches[j] = switches[j] == 0 ? 1 : 0;
                }
            }
            // 여자
            else {
                // 뽑은 수를 중심으로 좌우가 대칭이면 상태를 바꿈
                switches[number - 1] = switches[number - 1] == 0 ? 1 : 0;

                for (int j = 1; j < total/2; j++) {
                    if(number - 1 + j >= total || number - 1 - j < 0)
                        break;
                    if(switches[number - 1 - j] == switches[number - 1 + j]) {
                        switches[number - 1 - j] = switches[number - 1 - j] == 0 ? 1 : 0;
                        switches[number - 1 + j] = switches[number - 1 + j] == 0 ? 1 : 0;
                    }
                    else break; // 대칭이 아니면 끝냄
                }
            }
        }

        // 한 줄에 20개씩
        for (int i = 0; i < total; i++) {
            System.out.print(switches[i] + " ");
            if((i+1) % 20 == 0)
                System.out.println();
        }
    }
}
