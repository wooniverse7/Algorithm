package BOJ.Season09.P2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 1;
        // 현재 올리려는 저울추의 무게가, 지금까지 올린 저울추의 총합보다 커지면 저울추의 총합은 측정할 수 없는 최솟값
        for (int i = 0; i < N; i++) {
            if(sum < arr[i]){
                break;
            }
            sum += arr[i];
        }
        // 1 1 2 3 6 7 30
        // 1 ~ 7 -> 20

        System.out.println(sum);
    }
}
