package BOJ.P2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int num = Integer.parseInt(str);

        for (int i = 1; i <= num; i++) {
            int sum = i;
            String stri = Integer.toString(i);
            int lng = stri.length();

            for (int j = 0; j < lng; j++) {
                sum += stri.charAt(j) - '0';
                //System.out.println("sum 초기값 : " + sum);
            }
            //System.out.printf("i = %d, 분해합 sum = %d\n", i, sum);
            if(sum == num) {
                System.out.println(i);
                break;
            }
            if(i == num){
                System.out.println("0");
                break;
            }
        }

    }
}
