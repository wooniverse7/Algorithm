package SWEA.CT03;

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

            if(str.length() == 1){
                int num = str.charAt(0) - '0';
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
                System.out.print("#" + t + " ");
                boolean flag = true;
                for (int i = 0; i < str.length(); i++) {
                    int num = str.charAt(i) - '0';
                    if(num < x) flag = false;
                    break;
                }
                if(!flag){
                    for (int i = 0; i < str.length()-1; i++) {
                        System.out.print(y);
                    }
                }else {
                    for (int i = 0; i < str.length(); i++) {
                        int num = str.charAt(i) - '0';

                        if(num >= y){
                            System.out.print(y);
                        }else if(num == x){
                            System.out.print(x);
                        }else{
                        //else if (x <= num && num < y){
//                            sb.append(x);
                            System.out.print(x);
                            for (int j = i+1; j < str.length(); j++) {
//                                sb.append(y);
                                System.out.print(y);
                            }
                            break;
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}

