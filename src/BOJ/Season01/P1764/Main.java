package BOJ.Season01.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // HashSet 생성
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

//        String[] str = new String[M];
//        int cnt = 0;
//        
//        // 보도 못한 사람을 입력받아 듣도 못한 사람의 Set배열에 있는지 확인
//        for (int i = 0; i < M; i++) {
//            String tmp = br.readLine();
//            if(set.contains(tmp)){
//                str[cnt++] = tmp;
//            }
//        }
//        // str[] = {baesangwook, ohhenrie, null, null}이 되어 정렬을 할 수 없다.
//        Arrays.sort(str);
//        System.out.println(cnt);
//        for (int i = 0; i < cnt; i++) {
//            System.out.println(str[i]);
//        }
        
        // ArrayList<String> str = new ArrayList<>();로 하면 배열 크기 선언 필요 X
        ArrayList<String> sArr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine(); // 보도 못한 사람
            if(set.contains(tmp)){
                sArr.add(tmp); // 중복되면 배열에 추가
            }
        }

        Collections.sort(sArr); // 알파벳 순 정렬
        System.out.println(sArr.size());
        for (String s : sArr){
            System.out.println(s);
        }


    }
}
