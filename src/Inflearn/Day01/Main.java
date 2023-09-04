package Inflearn.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] chArr = str.toCharArray();

        int answer = 0;
        for(char c : chArr) {
            if(c >= 48 && c <= 57) {
                answer = answer * 10 + (c - 48);
            }
        }

        System.out.println(answer);
    }
}

