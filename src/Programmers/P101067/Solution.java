package Programmers.P101067;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {


    }

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        if(s.charAt(0) == ')') return false;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push('(');
            else {
                if(stack.empty()) return false;
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return false;
        else return true;
    }

}
