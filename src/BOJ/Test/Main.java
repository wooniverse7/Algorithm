package BOJ.Test;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(computeSquareRoot(144));
    }

    static final int PRECISION = 10;

    // 바빌로니아 방법
    static public String computeSquareRoot(int num) {
        // TODO:
        double x = PRECISION;

        // 원하는 정밀도 만큼 반복한다.
        for (int i = 0; i < PRECISION; i++)
            x = 0.5 * (num / x + x);

        x = Math.round(x*100) / 100.0;
        String rst = Double.toString(x);
        if(rst.charAt(rst.length()-1) == '0')
            rst = rst + "0";
        return rst;
    }
}
