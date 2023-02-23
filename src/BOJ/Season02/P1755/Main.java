package BOJ.Season02.P1755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static String[] abc = new String[101];
    static String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> al = new ArrayList<>();
        String[] str = new String[N-M+1];
        int idx = 0;
        for (int i = M; i <= N; i++) {
            if(i > 9){
                int ten = i / 10;
                int one = i % 10;
                String tmp = number[ten] + " " + number[one];
                al.add(tmp);
                str[idx++] = tmp;
            }else{
                String tmp = number[i];
                al.add(tmp);
                str[idx++] = tmp;
            }
        }

        Arrays.sort(str);
        //System.out.println(Arrays.toString(str));

        // 스플릿으로 공백 기준으로 나눠서 숫자 만들기
        int[] strToNum = new int[str.length+1]; // 출력때문에 한칸 늘려서 1부터 출력
        int idx2 = 1;
        for (int i = 0; i < str.length; i++) {
            // 두자리 수 일 때
            if(str[i].contains(" ")){
                String[] tmp = str[i].split(" ");
                int STI = 0;
                for (int j = 0; j < 10; j++) {
                    // 10의 자리
                    if(number[j].contains(tmp[0])){
                        STI += j * 10;
                    }
                    // 1의 자리
                    if(number[j].contains(tmp[1])){
                        STI += j;
                    }
                }
                strToNum[idx2++] = STI;
            }
            // 한자리 수 일 때
            else {
                int sti = 0;
                for (int j = 0; j < 10; j++) {
                    if(number[j].contains(str[i])){
                        sti += j;
                    }
                }
                strToNum[idx2++] = sti;
            }

        }
//        System.out.println(Arrays.toString(strToNum));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strToNum.length; i++) {

            if(i % 10 == 0) sb.append(strToNum[i]).append('\n');
            else{
                sb.append(strToNum[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
