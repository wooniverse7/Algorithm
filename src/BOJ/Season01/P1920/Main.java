package BOJ.Season01.P1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 입력
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] b = new int[M];
        for (int i = 0; i < M; i++) {
            b[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(a);

        // 탐색 방법 1. 이진 탐색 구현
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int rst = binarySearch(a, b[i]);
            sb.append(rst).append('\n');
        }

        System.out.println(sb);

        // 탐색 방법 2. 자바 메서드 사용
//        StringBuilder sb2 = new StringBuilder();
//        for (int i = 0; i < M; i++) {
//            if(Arrays.binarySearch(a,b[i]) >= 0)
//                sb2.append("1").append('\n');
//            else
//                sb2.append("0").append('\n');
//        }
//        System.out.println(sb2);
    }

    // 이진 탐색 구현. ArrayIndexOutOfBoundsException 에러 발생
    static int binarySearch(int[] arr, int key){
        int mid;

        int lo = 0;
        int hi = arr.length - 1;

        // lo값이 hi값보다 커지기 전까지 반복
        while(lo <= hi){
            mid = (lo + hi) / 2;

            if(key == arr[mid]){
                return 1; // 키와 mid값이 같으면 있으니 1 리턴
            }else if(key < arr[mid]){ // key값이 중간값보다 작을 경우
                hi = mid - 1; // 중간 idx - 1이 upperBound가 됨
            }else{
                lo = mid + 1; // 중간 idx + 1이 lowerBound가 됨
            }
        }

        // 없으면 0 리턴
        return 0;
    }

}


