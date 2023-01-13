package BOJ.P2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int five = N / 5;
        System.out.println(recursion(N, five));

    }

    static int recursion(int n, int five){
        int three = (n - 5*five) / 3;
        if(five == -1) return -1;
        if((n-5*five-3*three) == 0) return five + three;

        return recursion(n, five -1);
    }
}

