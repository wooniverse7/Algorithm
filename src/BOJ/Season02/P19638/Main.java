package BOJ.Season02.P19638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // PQ의 가장 우선순위가 센티보다 작아야 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int times = Integer.parseInt(st.nextToken());

        int[] height = new int[people];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < people; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        while(times > 0){

            if(pq.peek() < centi) break;

            if(pq.peek() >= centi){
                if(pq.peek() == 1) {
                    pq.poll();
                    pq.offer(1);
                }else{
                    pq.offer(pq.poll()/2);
                }

                times--;
                cnt++;
            }
        }

        if(pq.peek() >= centi){
            System.out.println("NO");
            System.out.println(pq.peek());
        }else{
            System.out.println("YES");
            System.out.println(cnt);
        }
    }
}
