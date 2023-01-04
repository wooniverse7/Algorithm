package BOJ.P4949;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> st = new Stack<>();

        while(true){
            String str = sc.nextLine();
            // 종료 조건
            if(str.equals(".")) break;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(' || c == '['){ // 여는 소괄호 push
                    st.push(c);
                }
                else if(c == ')'){ // 닫는 소괄호 pop 조건
                    // 불균형 조건 : 빈 스택이거나 top이 여는 소괄호가 아닐 때
                    if(st.empty() || st.peek() != '('){
                        st.push(c);
                        break;
                    }else // 정상이면 pop
                        st.pop();
                }
                else if(c == ']'){
                    // 불균형 조건 : 빈 스택이거나 top이 여는 대괄호가 아닐 때
                    if(st.empty() || st.peek() != '[') {
                        st.push(c);
                        break;
                    }else
                        st.pop();
                }
            }

            //System.out.println(st);
            // 끝까지 돌았고 빈 스택이면 정상
            if(st.empty()) System.out.println("yes");
            else System.out.println("no");
            st.clear();
        }

    }
}
