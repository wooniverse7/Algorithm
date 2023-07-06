package BOJ.Season5.P1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Data {
    int weight;
    int value;

    public Data(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {
    static PriorityQueue<Integer> pq;
    static int N, K;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Data[] datas = new Data[N];
        bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int won = Integer.parseInt(st.nextToken());

            datas[i] = new Data(weight, won);
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 무게 오름차순 -> 가격 내림차순
        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.weight == o2.weight) {
                    return o2.value - o1.value;
                }
                return o1.weight - o2.weight;
            }
        }); // value를 기준으로 내림차순으로 정렬
        Arrays.sort(bag);

        pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        long ans = 0;

        // 가방 개수만큼
        for (int i = 0; i < K; i++) {
            int nowBag = bag[i]; // 현재 가방 무게

            // 가방 개수보다 보석 개수가 많으면
            while(idx < N) {
                //보석의 정보가 이미 정렬되어 있으므로 한 번 순회하며 자기가 담을 수 있는 보석까지만 삽입
                if(datas[idx].weight <= nowBag) {
                    pq.offer(datas[idx].value);
                    idx++;
                }
                else {
                    break;
                }
            }
            // PQ에서 보석 하나를 꺼내어 담는 처리(정답에 누적합) 후
            if (!pq.isEmpty()){
                ans += pq.poll();
            }
            // 다음 크기의 가방에 대해 같은 작업을 반복
        }

        System.out.println(ans);
    }
}


