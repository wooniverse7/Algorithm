package SKP2023.p1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] bread_schedule1 = {"09:05 10", "12:20 5", "13:25 6", "14:24 5"};
        String[] bread_schedule2 = {"12:00 10"};
        String[] bread_schedule3 = {"12:00 10"};

        String current_time1 = "12:05";
        String current_time2 = "12:00";
        String current_time3 = "12:00";

        int k1 = 10;
        int k2 = 10;
        int k3 = 11;

        System.out.println(solution(bread_schedule1, current_time1, k1));
        System.out.println(solution(bread_schedule2, current_time2, k2));
        System.out.println(solution(bread_schedule3, current_time3, k3));
    }

    public static int solution(String[] bakery_schedule, String current_time, int k) {
        int answer = -2;

        // 스케쥴을 시간과 개수 배열 두 개로 변환
        int size = bakery_schedule.length;
        String[] time = new String[size];
        int[] bread = new int[size];

        for (int i = 0; i < size; i++) {
            String[] tmp = bakery_schedule[i].split(" ");
            time[i] = tmp[0];
            bread[i] = Integer.parseInt(tmp[1]);
        }

        // 시간 배열을 분 단위로 치환
        // 가게 시간 치환
        int[] time2 = new int[size];
        for (int i = 0; i < size; i++) {
            String[] tmp = time[i].split(":");
            int h = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            time2[i] = h*60 + m;
        }
        // 현재 시간 치환
        String[] tmp1 = current_time.split(":");
        int a = Integer.parseInt(tmp1[0]);
        int b = Integer.parseInt(tmp1[1]);
        int cur = a * 60 + b;

        // 인덱스 비교
        int sum = 0;
        int str = 0;
        int end = 0;

        // 시작점 구하기
        for (int i = 0; i < size; i++) {
            // 현재시간부터 합계
            if(time2[i] >= cur){
                str = i;
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            // 현재시간부터 합계
            if(time2[i] >= cur){
                sum += bread[i];

                if(sum >= k){
                    end = i;
                    break;
                }
            }
        }
//        System.out.println(str + " " + end);

        if(sum < k) return answer = -1;

//        if(str == 0) return answer = 0;
        else{
            answer = time2[end] - cur;

            return answer;
        }

    }
}
