package BOJ.Season03.P3566_2;

import java.util.Scanner;
import java.lang.Math;

public class Main {

    static int monitor_num, rh, rv, sh, sv, rhi, rvi, shi, svi, pi, result = Integer.MAX_VALUE, tem;

    // 두 숫자 중 더 높은 숫자 리턴.
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    // 두 숫자 중 더 낮은 숫자 리턴.
    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    // 특정 모니터를 사용할 때 소비될 총 비용.
    public static int calculate(int a, int b, int c, int d, int price) {
        int highest_h, highest_v;

        // 세로 화면 해상도, 세로 화면 크기를 만족시키기 위해 필요한 모니터 개수.
        highest_h = max((int) Math.ceil((double) rh / a), (int) Math.ceil((double) sh / c));

        // 가로 화면 해상도, 가로 화면 크기를 만족시키기 위해 필요한 모니터 개수.
        highest_v = max((int) Math.ceil((double) rv / b), (int) Math.ceil((double) sv / d));

        // 총 비용 = 가로로 필요한 모니터 개수 * 세로로 필요한 모니터 개수 * 모니터 하나당 비용
        return highest_h * highest_v * price;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        rh = scanner.nextInt();
        rv = scanner.nextInt();
        sh = scanner.nextInt();
        sv = scanner.nextInt();
        monitor_num = scanner.nextInt();

        for (int j = 0; j < monitor_num; j++) {
            rhi = scanner.nextInt();
            rvi = scanner.nextInt();
            shi = scanner.nextInt();
            svi = scanner.nextInt();
            pi = scanner.nextInt();

            // 기본 상태로 계산한 비용, 가로 세로를 바꿔서 계산한 비용,
            // 지금까지 구한 비용 중 최저 비용 중 가장 낮은 것으로 선택해서 최저 비용을 업데이트.
            result = min(result, min(calculate(rhi, rvi, shi, svi, pi), calculate(rvi, rhi, svi, shi, pi)));
        }

        System.out.println(result);
    }
}