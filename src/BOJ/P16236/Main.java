package BOJ.P16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 맵 크기
    static int[][] map, dist; // 맵
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int shark = 2, sharkX, sharkY; // 상어의 크기, 좌표
    static int eatCnt = 0;
    final static int maxVal = 401, maxInt = 21;
    static int minDist, minX, minY; // 물고기와의 최소 거리, 그 물고기의 좌표
    static int time = 0; // 걸린 시간

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0; // 상어 자리 초기화
                }
            }
        }

        // 상어가 움직일 때 마다 bfs를 돌림
        while(true){
            init(); // 매 번 돌 때 마다 거리, 방문 체크 초기화

            bfs(sharkX, sharkY);

            // 탈출 조건. bfs를 끝까지 돌았을 때, minX, minY가 초기화 값이랑 일치한다는 것은 더이상 탐색할 곳이 없다는 것을 의미
            if(minX == maxInt && minY == maxInt){
                break;
            }else{
                time += dist[minX][minY];
                eatCnt++;

                if(shark == eatCnt){
                    shark++;
                    eatCnt = 0;
                }

                // 먹은 물고기 자리
                map[minX][minY] = 0;

                // 상어 이동
                sharkX = minX;
                sharkY = minY;
            }

        }

        System.out.println(time);
    }

    static void bfs(int x, int y){
        // 상어 좌표 큐 삽입
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {x, y});
        dist[x][y] = 0;

        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 방문 체크 & 상어 크기 체크
                if(dist[nx][ny] != -1 || map[nx][ny] > shark) continue;
                // 이동가능 하면
                // 현재 상어와 물고기 사이의 거리 배열이 필요
                dist[nx][ny] = dist[x][y] + 1;

                // 물고기 섭취 - 조건이 있음
                // 먹을 수 있는 물고기만 x좌표 차이, y좌표 차이
                if(map[nx][ny] != 0 && map[nx][ny] < shark){

                    // 해당 좌표에 먹을 수 있는 물고기가 있으면 minX, minY, minDist와 비교해 최소값 저장
                    if(minDist > dist[nx][ny]){
                        minX = nx;
                        minY = ny;
                        minDist = dist[nx][ny];
                    } // 거리가 같으면
                    else if(minDist == dist[nx][ny]){
                        //위쪽 우선
                        if(minX == nx){
                            // 같은 높이차라면 가장 왼쪽
                            if(minY > ny){
                                minX = nx;
                                minY = ny;
                            }
                        }else if(minX > nx){ // 더 높은게 있다면
                            minX = nx;
                            minY = ny;
                        }
                    }
                } // 먹을 수 있는 물고기 비교
                Q.offer(new int[]{nx, ny});
            } // 4방향 순회
        } // while문
    }

    static void init(){
        minDist = maxVal;
        minX = maxInt;
        minY = maxInt;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }
    }

}
