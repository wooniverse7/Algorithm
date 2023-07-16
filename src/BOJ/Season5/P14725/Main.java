package BOJ.Season5.P14725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 터널 개수
        TreeMap<String, TreeMap> map = new TreeMap<>(); // 먹이와 터널 정보 저장

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            TreeMap cur = map; // 현재 탐색 노드. 자식 노드들을 저장

            for (int j = 0; j < k; j++) {
                String food = st.nextToken();
                // 탐색중인 노드에 해당 음식이름이 없으면 추가
                if(cur.get(food) == null) {
                    cur.put(food, new TreeMap<>());
                }
                cur = (TreeMap) cur.get(food); // 다음 계층으로 갱신(for 계층구조)
            }
        }

        print(map, 0);
        System.out.println(sb);
    }

    static void print(TreeMap map, int depth){

        // dfs
        // 루트 노드부터 leaf 노드까지 자식 노드를 타면서 출력.
        for(Object s : map.keySet()) {
            for (int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(s + "\n");
            print((TreeMap) map.get(s), depth+1);
        }
    }
}

/**
 * TreeMap 활용법
 * https://coding-factory.tistory.com/557
 */
