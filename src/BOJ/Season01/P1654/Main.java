package BOJ.Season01.P1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] line = new int[K];
        long end = 0; // 자료형 조심
        long srt = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if(line[i] > end){
                end = line[i];
            }
        }
        end++; // 랜선 두개가 같을 경우를 대비해 ++


        while(srt < end){
            long mid = (srt + end) / 2;
            long cnt = 0;

            for (int i = 0; i < line.length; i++) {
                cnt += line[i] / mid;
            }
            //System.out.println("cnt : " + cnt);
            // 적으면 최대 길이를 mid로 바꿔서 자르는 길이를 짧게 해서 개수를 늘린다.
            if(cnt < N){
                end = mid;
            }else{ // 개수가 같거나 많으면 이제 길이의 upper bound를 찾기 위해 길이를 1cm씩 늘린다.
                srt = mid + 1;
            }
        }

        System.out.println(srt - 1);

    }

}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
//        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
//
//        long[] lan = new long[K];
//
//        for (int i = 0; i < K; i++) {
//            lan[i] = Integer.parseInt(br.readLine());
//        }
//
//        System.out.println(bst(lan, N));
//
//    }
//
//    static long bst(long[] line, int N){
//
//        long min = 0;
//        long max = -1; // 자료형..
//        for (int i = 0; i < line.length; i++) {
//            if(max < line[i]) max = line[i];
//        }
//        max++; // 랜선 두개가 0,0이나 같을 경우를 대비해 while문이 동작할 수 있도록 max값을 1 증가시켜줌
//
//        while(min < max){
//            long mid = (min + max) / 2;
////            System.out.println(mid);
//            long sum = 0; // 랜선 개수 합, 줄이 1만개 있고
//
//            for (int i = 0; i < line.length; i++) {
//                // mid 길이로 잘랐을 때 몇 개 나오는지
//                sum += line[i] / mid;
//            }
//
//            if(sum >= N){ // 최장 길이를 찾기 위해 '=' 필요
//                // 원하는 개수보다 많을 때 lowerBound를 올림
//                min = mid + 1;
//            }else{
//                // uppperBound를 낮춤
//                max = mid;
//            }
//
//
//        }
//
//        return min - 1;
//    }
//}
