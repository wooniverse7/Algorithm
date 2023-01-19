package BOJ.P2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 산술 평균
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        int sanSul = (int)Math.round((double) sum / N);
        System.out.println(sanSul);

        // 중앙값
        Arrays.sort(arr);
        int middle = arr[N/2];
        System.out.println(middle);

        // 최빈값
        int[] cntArr = new int[8002]; // Counting Sort용, 음수를 양수로 바꿈
        for (int i = 0; i < N; i++) {
            cntArr[arr[i] + 4000]++; // 빈도 저장
        }

        ArrayList<Integer> beanDo = new ArrayList<>(); // 빈도를 담을 배열
        // 가장 높은 빈도수 구하기
        int max = 0;
        for (int i = 0; i < cntArr.length; i++) {
            max = Math.max(max, cntArr[i]);
        }
        // 가장 높은 빈도의 값들을 저장
        for(int n : arr){
            int an = n + 4000; // 양수화
            if(cntArr[an] == max && !(beanDo.contains(an))){
                beanDo.add(an);
            }
        }

        int third = 0;
        // 빈도가 같은게 2개 이상이면 2번째로 작은 것 출력
        if(beanDo.size() >= 2){
            third = beanDo.get(1) - 4000;
        }else {
            third = beanDo.get(0) - 4000;
        }
        System.out.println(third);

        int differ = arr[N-1] - arr[0];
        System.out.println(differ);

    }
}
