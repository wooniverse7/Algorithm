package BOJ.Season2.P9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bomb = br.readLine();
        int size = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);

            // 폭탄 사이즈 이상이 쌓이면 탐색 시작
            if(sb.length() >= size){
                boolean flag = true;
                // 원본배열과 폭탄 비교
                for (int j = 0; j < size; j++) {
                    char one = sb.charAt(sb.length() - size + j); // 처음에서 i만큼 더하고 size만큼 빼고 j씩 더하기
                    char two = bomb.charAt(j);
                    if(one != two){
                        flag = false;
                        break;
                    }
                }
                // 끝까지 돌았는데 flag가 true이면 폭탄과 같다는 말
                if(flag){
                    sb.delete(sb.length() - size, sb.length()); // delete(시작, 끝)
                }
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }

    }
}
