package BOJ.Season02.P14719;

/**
 * 스택을 사용해서 풀이
 * 시간 복잡도 O(n)
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[] blocks = new int[w];
        for (int i = 0; i < w; i++) {
            blocks[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < w; i++) {
            while (!stack.isEmpty() && blocks[i] > blocks[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int distance = i - stack.peek() - 1;
                int height = Math.min(blocks[i], blocks[stack.peek()]) - blocks[top];
                result += distance * height;
            }

            stack.push(i);
        }

        System.out.println(result);
    }
}

