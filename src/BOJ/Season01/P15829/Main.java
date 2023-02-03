package BOJ.Season01.P15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i) - 'a' + 1;
        }

        BigInteger bi = new BigInteger("0");
        for (int i = 0; i < N; i++) {
            // BigInteger += 알파벳의 숫자 * 31의 i제곱
            bi = bi.add(BigInteger.valueOf(str.charAt(i) - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));
        }
        //mod 1234567891
        System.out.println(bi.remainder(BigInteger.valueOf(1234567891)));
    }
}
