package BOJ.Season01.P1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] map = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int N, K;
    static Queue<Integer> queue = new LinkedList<>(); // 전체로 선언해야 NPI 안뜸
    static int[] dx = {-1, 1, 2};

    public static void main(String[] args) {
        // 브루트 포스 알고리즘?
        // 순간이동으로 가장 빨리 가는 시간에서 순간이동을 줄여 한 칸씩 이동을 추가?
        // 매 칸마다 두 배수를 했을 때의 시간을 비교?
        // 2 배를 이동했을 때 뒤로 한 칸씩 움직여서 두 배수, 앞으로 한 칸씩 움직여서 두 배수
        // 그냥 BFS를 방문 처리해서 모든 경우의 수를 구하면 되나?
        // map의 각 인덱스마다 최소값을 저장해서 도착지까지 최소값이 도출되도록 약간 DP느낌?

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        System.out.println(bfs(N));
    }

    // 시간에 따라 이동값을 저장해 이미 갔던 곳은 돌아가지 않는다.
    static int bfs(int n){
        // 큐 삽입
        queue.offer(n);
        map[N] = 1;
        visited[N] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            // 탈출문
            if(cur == K) {
                // 시작값이 1이기 때문에 -1
                return map[cur] - 1;
            }

            // 다음 노드 3곳 이동(+1, -1, *2)
            // x-1 이동
            if(cur - 1 >= 0 && !visited[cur-1]){ // '=' 추가 -> 정답
                map[cur-1] = map[cur] + 1;
                visited[cur-1] = true;
                queue.offer(cur-1);
            }
            // x+1 이동
            if(cur + 1 < 100001 && !visited[cur+1]){
                map[cur+1] = map[cur] + 1;
                visited[cur+1] = true;
                queue.offer(cur+1);
            }
            // x * 2 이동
            if(cur * 2 < 100001 && !visited[cur*2]){
                map[cur*2] = map[cur] + 1;
                visited[cur*2] = true;
                queue.offer(cur*2);
            }
        }

        // 없으면
        return -1;
    }
}

// 2 10
// 2 4 8 9 10
// 2 3 4 8 9 10