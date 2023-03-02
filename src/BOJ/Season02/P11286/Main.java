package BOJ.Season02.P11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

//        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
//            // 파라미터로 받은 o1, o2는 기본적으로 object 형이기 때문에
//            // string으로 변환 후, int형으로 다시 변환
//            int x = Integer.parseInt(a.toString());
//            int y = Integer.parseInt(b.toString());
//
//            // x, y가 들어왔을 때, 절대값이 낮은 것을 우선순위로 하려면?
//            // 음수가 나와야 x가 앞에 온다. y가 더 크니까 음수가 나온다.
//            if(Math.abs(x) < Math.abs(y)){
//                return x - y;
//            } else if(Math.abs(y) < Math.abs(x)){
//                return y - x;
//            }else{ // 값이 같으면 원래 수 비교
//                if(x < y){
//                    return x - y;
//                }else
//                    return y - x;
//            }
//        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 절대값 기준 오름차순. 앞 값이 더 크면 자리를 바꿔준다.
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2); // 절대값으로 비교해서 음수가 나와야 비교됨
                }else if(Math.abs(o1) == Math.abs(o2)){
                    // 절대값이 같다면 음수가 우선순위. 앞으로 이동
                    return o1 - o2; // 이게 왜 음수가 앞이지
                }else {
                    return -1;
                }
            }
        });

        // 2차원 배열로 만들어서, 절대 값과 원래 수를 같이 입력
        // 절대값 먼저 비교하고 같으면 그냥 크기 비교
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 0){
                pq.offer(tmp);
            }else{
                if(pq.isEmpty()) sb.append(0).append('\n');
                else{
                    // 원래 수 출력
                    sb.append(pq.poll()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

}
