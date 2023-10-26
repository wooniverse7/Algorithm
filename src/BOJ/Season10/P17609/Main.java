package BOJ.Season10.P17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String str;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            str = br.readLine();

            if(check(str)){
                System.out.println(0);
                continue;
            }else {
                for (int i = 0; i < str.length(); i++) {
                    if(reChk(str, i)) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println(1);
            }else {
                System.out.println(2);
            }

            flag = false;
        }
    }

    public static boolean check(String str) {
        int lf = 0;
        int rt = str.length()-1;

        while(lf <= rt) {
            if(str.charAt(lf) != str.charAt(rt)){
                return false;
            }
            lf++;
            rt--;
        }
        return true;
    }

    public static boolean reChk(String str, int idx) {
        String string = newString(str, idx);
        return check(string);
    }

    public static String newString(String str, int index){
        String str1 = str.substring(0, index);
        String str2 = str.substring(index + 1);
        return str1.concat(str2);
    }
}
