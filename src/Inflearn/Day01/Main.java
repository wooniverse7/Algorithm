package Inflearn.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char c = br.readLine().charAt(0);
        if(c < 'a') {
            c += 32;
        }

        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp < 'a'){
                tmp += 32;
            }
            arr[i] = tmp;
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == c) cnt++;
        }

        System.out.println(cnt);
    }
}
