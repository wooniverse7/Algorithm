package BOJ.Season01.P1259;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            if(str.equals("0")) break; // 종료

            int lng = str.length();

            boolean fl = true; // 펠린드롬인지 아닌지 flag
            for (int i = 0; i < lng / 2 + 1; i++) { // (lng/2 + 1) = 3 -> 0-4, 1-3, 2-2
                if (str.charAt(i) != str.charAt(lng - 1 - i)) {
                    fl = false;
                    break;
                }
            }
            if (fl == true) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
