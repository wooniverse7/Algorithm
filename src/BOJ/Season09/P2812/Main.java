package BOJ.Season09.P2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        str = br.readLine();
        int len = n - k;

        Stack<Character> stack = new Stack<>();

        // 1924
        // 1
        // 9
        // 92
        // 94
        for(int i = 0; i < str.length(); i++) {
            // 다음 숫자가 더크면 스택 top을 빼고 새로 삽입
            while(!stack.empty() && k > 0 && stack.peek() < str.charAt(i)) {
                stack.pop();
                k--;
            }

            // 비어있으면 삽입
            stack.push(str.charAt(i));
        }

        // k개 만큼 빼지 않은 경우
        // 10000 2
        // 1
        // 1 0
        while(true) {
            if(stack.size() == len) break;

            stack.pop();
        }

        // 4 9
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse()); // 94
    }
}

