package BOJ.Season01.P11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];

        StringTokenizer st; // 입력받은 값을 잘라야 해서 선언만 해줌
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine()); // Token 버퍼에 담아두기
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2중 배열 정렬을 위해 람다식 사용
        // arr의 현재 원소와 다음 원소 비교
        Arrays.sort(arr, (e1, e2) ->{
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{ // 다를 때
                return e1[0] - e2[0];
            }
            // return 되는 값이 음수일 경우 위치를 바꾸지 않고, 양수일 경우 위치를 바꾼다.
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);

    }
}
