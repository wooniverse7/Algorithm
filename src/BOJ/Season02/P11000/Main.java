package BOJ.Season02.P11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ST = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            ST[i][0] = Integer.parseInt(st.nextToken());
            ST[i][1] = Integer.parseInt(st.nextToken());
        }
        // 시작 시간 기준으로 정렬(오름차순), 같으면 종료 시간 기준으로 정렬
        Arrays.sort(ST, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
//        System.out.println(Arrays.deepToString(ST));

        // 종료 시간을 담을 PQ 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(ST[0][1]);

        // 첫번째 종료시간과 두번째 시작시간 비교
        // PQ의 종료시간과 ST의 시작시간 비교
        for (int i = 1; i < N; i++) {
//            System.out.println(pq.size() + " " + pq.peek() + " " + ST[i][0]);
            if(pq.peek() <= ST[i][0]){
                // 시작 시간이 종료시간보다 크거나 같다면
                pq.poll();
            }

            // 다음 종료 시간 삽입
            pq.offer(ST[i][1]);
        }

        // 다 끝났을 때 PQ에 남은 개수가 필요한 강의실 개수가 됨.
        System.out.println(pq.size());
    }
}
