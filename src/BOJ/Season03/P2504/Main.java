package BOJ.Season03.P2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<String> stack = new Stack<String>();

        // 모든 과정이 끝난 뒤에는 숫자만 남아야 한다.

        // 닫는 괄호일 때 스택 Top이 숫자일 경우 숫자를 pop하면서 전부 더하고 본인의 괄호 계산값을 더하여 다시 push

        // 닫는 괄호일 때 top이 괄호일 때, 본인 괄호 값만 더하고 스택에 push

        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            String tmp = str.substring(i, i+1);

            // 여는 괄호. 짝 괄호를 스택에 push
            if(tmp.equals("(")){
                stack.push(")");
                continue;
            }
            if (tmp.equals("[")){
                stack.push("]");
                continue;
            }

            // 닫는 괄호 일 경우 스택이 빌 때 까지 pop
            // 짝이 없는데 스택이 비어있다면 flag는 false
            // 숫자가 나오면 flag = false. 숫자는 계속 합한다.
            // 짝이 맞으면 본인 괄호 크기에 합한 수를 곱한뒤 그 값을 push
            int num = 0;
            while(true) {
                // 짝 괄호가 없는데 스택이 비었을 때
                if(stack.isEmpty()){
                    flag = false;
                    break;
                }

                if(isNumber(stack.peek())){
                    // 숫자이면
                    num += Integer.parseInt(stack.pop());
                }else {
                    // 숫자가 아니면
                    // 주어진 괄호와 top이 같으면
                    if(isVPS(tmp, stack.peek())){
                        stack.pop();
                        int t = (tmp.equals(")")) ? 2 : 3;

                        if(num == 0) {
                            stack.push(String.valueOf(t));
                        }else {
                            stack.push(String.valueOf(t * num));
                        }
                        break;
                    }else {
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag) break;
        }

        int rst = 0;

        // 스택이 빌 때 까지 pop
        // 정상적인 문자열이라면 숫자만 남아있어야 함
        while(!stack.isEmpty()){
            if(isNumber(stack.peek())) {
                rst += Integer.parseInt(stack.pop());
            }else {
                flag = false;
                break;
            }
        }

        if(flag) System.out.println(rst);
        else System.out.println(0);
    }

    // 두 괄호가 아니면 숫자
    public static boolean isNumber(String str) {
        if(str.equals(")") || str.equals("]")) return false;
        return true;
    }

    public static boolean isVPS(String tmp, String target) {
        if(tmp.equals(target)) return true;
        return false;
    }
}
