package SWEA.CT02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String str = st.nextToken();
            String n1 = st.nextToken();
            String n2 = st.nextToken();
            int x = Integer.parseInt(n1);
            int y = Integer.parseInt(n2);

            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            //System.out.println("str.length : " + str.length());

            if(str.length() == 1){
                int num = str.charAt(0) - '0';
                //System.out.println("num : " + num);
                //System.out.println("x : " + x);
                //System.out.println("y : " + y);
                if(num < x){
                    System.out.printf("#%d %d\n", t, -1);
                }else if(num >= y){
                    System.out.printf("#%d %d\n", t, y);
                }else{
                    if(x == 0)  System.out.printf("#%d %d\n", t, -1);
                    else System.out.printf("#%d %d\n", t, x);
                }
                // 스트링이 2자리 이상일 경우
            }
            else{
                boolean flag = true;
                for (int i = 0; i < str.length(); i++) {
                    int num = str.charAt(i) - '0';
                    if(num >= y){
                        sb.append(y);
                    }else if (num < x){
                        //System.out.println("lng : " + str.length());
                        flag = false;
                        for (int j = 0; j < str.length() - 1; j++) {
                            sb2.append(y);
                        }
                        break;
                    }else if(num == x){
                        sb.append(x);
                    }else{ // x < num인 수가 있을때
                        sb.append(x);
                        for (int j = i+1; j < str.length(); j++) {
                            sb.append(y);
                        }
                        break;
                    }
                }
                if(flag){
                    System.out.printf("#%d ", t);
                    System.out.println(sb);
                }else{
                    System.out.printf("#%d ", t);
                    System.out.println(sb2);
                }
            }
        }
    }
}
