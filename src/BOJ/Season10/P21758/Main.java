package BOJ.Season10.P21758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = leftHoney(); // 꿀 - 벌 - 벌
        int right = rightHoney(); // 벌 - 벌 - 꿀
        int mid = midHoney(); // 벌 - 꿀 - 벌

        int max = Math.max(left, Math.max(right, mid));
        System.out.println(max);
    }

    // 꿀-벌-벌
    public static int leftHoney() {
        int sum[] = new int[arr.length]; // 누적합

        // 꿀 - 벌 - 벌에서 꿀과 오른쪽 벌은 양 끝점에 고정
        // 가운데 벌을 오른쪽 끝에서 왼쪽으로 이동
        for (int i = arr.length - 2; i >= 1; i--) {
            sum[i] = sum[i + 1] + arr[i + 1];
        }

        int endSum = sum[1];
        int max = 0;

        for (int i = 2; i < arr.length; i++) {
            max = Math.max(max, endSum - arr[i] + sum[i]);
        }

        return max;
    }

    // 벌-벌-꿀
    public static int rightHoney() {
        int sum[] = new int[arr.length];

        // 벌 - 벌 - 꿀에서 왼쪽 벌과 꿀은 양 끝점에 고정
        for (int i = 2; i < arr.length; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }

        int endSum = sum[arr.length - 1];
        int max = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            max = Math.max(max, endSum - arr[i] + sum[i]);
        }

        return max;
    }

    // 벌-꿀-벌
    // 벌통을 옮기면서 최댓값을 구한다.
    public static int midHoney(){
        int leftSum[] = new int[arr.length];
        int rightSum[] = new int[arr.length];

        // 왼쪽 벌에서 끝까지
        for (int i = 2; i < leftSum.length; i++) {
            leftSum[i] = leftSum[i-1] + arr[i];
        }

        // 오른쪽 벌에서 처음까지
        for (int i = arr.length - 2; i >= 1; i--) {
            rightSum[i] = rightSum[i+1] + arr[i];
        }

        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, leftSum[i] + rightSum[i]);
        }

        return max;
    }
}
