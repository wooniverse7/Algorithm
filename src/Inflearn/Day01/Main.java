package Inflearn.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        str = str.toLowerCase(Locale.ROOT).replaceAll("[^a-z]", "");

        char[] chArr = str.toCharArray();

        int lf = 0;
        int rt = str.length() - 1;

        while(lf < rt) {
            if(!Character.isAlphabetic(chArr[lf])){
                lf++;
                rt--;
            }
            if(chArr[lf] == chArr[rt]){
                lf++;
                rt--;
            }else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}

