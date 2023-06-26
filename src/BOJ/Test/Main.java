package BOJ.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {
    static int R;
    static int C;

    static String[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        map = new String[R][C];
        int x=0;
        int y=0;

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {

                String one = String.valueOf(str.charAt(c));
                if(one.equals("S")) {
                    x=r;
                    y=c;
                    one="0";
                }
                if(one.equals(".")){
                    one="0";
                }
                map[r][c] = one;

            }
        }

        Point2 start=new Point2(x,y, map);
        BFS3(start);
    }

    static void BFS3(Point2 start) {

        boolean[][] visited = new boolean[R][C];
        Queue<Point2> go = new LinkedList<>();
        go.add(start);
        visited[start.x][start.y] = true;

        while (!go.isEmpty()) {

            Point2 now = go.poll();
            System.out.println("전:");
            printMap(now.pmap);

            if(now.pmap[now.x][now.y].equals("D")) {
                System.out.println(map[now.x][now.y]);
                return;
            }

            String[][] map = overflowWater(now.pmap);
            System.out.println("홍수 후:");
            printMap(map);

            for (int i = 0; i < 4; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                if (0 <= tx && tx < R && 0 <= ty && ty < C) {

                    if (visited[tx][ty]) continue;
                    if (map[tx][ty].equals("D")){
                        System.out.println(Integer.parseInt(now.pmap[now.x][now.y])+1);
                        return;
                    }
                    if (now.pmap[now.x][now.y].equals("*")||map[tx][ty].equals("*")) continue;
                    if (map[tx][ty].equals("X")) continue;

                    map[tx][ty] = String.valueOf(Integer.parseInt(map[now.x][now.y]) + 1);
                    go.add(new Point2(tx,ty,map));
                    System.out.println("모든 조건 충족후 처리:");
                    printMap(map);
                    visited[tx][ty] = true;
                }
            }
        }

        System.out.println("KAKTUS");
    }
    static String[][] overflowWater(String[][] origin) {

        String[][] newMap = new String[R][C];
        IntStream.range(0, R)
                .forEach(e -> newMap[e] = Arrays.copyOf(origin[e], origin[e].length));

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (origin[r][c].equals("*")) {
                    newMap[r][c] = "*";
                    for (int i = 0; i < 4; i++) {
                        int tx = r + dx[i];
                        int ty = c + dy[i];
                        if (0 <= tx && tx < R && 0 <= ty && ty < C) {
                            if (!origin[tx][ty].equals("D") && !origin[tx][ty].equals("X")) {
                                newMap[tx][ty] = "*";
                            }
                        }
                    }
                }
            }
        }
        //printMap(newMap);
        return newMap;
    }

    static void printMap(String[][] map) {
        IntStream.range(0, map.length)
                .forEach(e -> System.out.println(Arrays.toString(map[e])));
        System.out.println("-----------------");
    }

    static class Point2 {
        int x;
        int y;
        String[][] pmap;

        public Point2(int x, int y, String[][] pmap) {
            this.x = x;
            this.y = y;
            this.pmap=pmap;
        }
    }
}
