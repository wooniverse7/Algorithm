package BOJ.Test;
import java.io.*;
import java.util.*;


public class Main {

    static int sum = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;



        while(true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;

            if((a * a + b * b) == c * c) {
                System.out.println("right");
            }
            else if(a * a == (b * b + b * b)) {
                System.out.println("right");
            }
            else if(b * b == (c * c + a * a)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }

//            int[] arr = new int[3];
//            for (int i = 0; i < 3; i++) {
//                arr[i] = Integer.parseInt(st.nextToken());
//            }
//
//            // 탈출
//            for (int i = 0; i < 3; i++) {
//                sum += arr[i];
//            }
//            System.out.println(sum);
//            if(sum == 0) break;
//
//            Arrays.sort(arr);
//            if(arr[2] * arr[2] == arr[1] * arr[1] + arr[0] * arr[0]){
//                System.out.println("right");
//            }else{
//                System.out.println("wrong");
//            }
//

        }

    }
}

