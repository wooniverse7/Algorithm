package BOJ.Season2.P1701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 초기 버전. 하나의 문자열만 중복 문자열 길이 구함
        table = makeTable(str);
        
        int max = 0;
        for (int i = 0; i < table.length; i++) {
            if(max < table[i]){
                max = table[i];
            }
        }
        System.out.println(Arrays.toString(table));
        System.out.println(max);
        // 시간 복잡도 : 스트링 길이


        // 모든 부분 문자열에서 중복 문자열 최대 길이 구하기
        int max2 = 0;
        // 앞에서부터 하나씩 줄여가며 부분 문자열을 만든다.
        for (int i = 0; i < str.length(); i++) {
            int tmp = getpi(str.substring(i, str.length()));
            max2 = Math.max(max2, tmp);
        }
        System.out.println(max2);
        // 시간 복잡도 : 스트링 길이/2 * 스트링 길이 = 2500 * 5000 = 12500000(1천250만)

    }
    // 기본적인 kmp table을 만드는 메서드
    // 고정된 한 문자열에서 table을 만드는 메서드
    // 한 문자열에서의 최대 중복 문자열만 구할 수 있다.
    static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++) {
            // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }

    // Upgrade
    // 테이블을 만들지 말고 바로 최댓값을 구하기
    public static int getpi(String s) {
        table = new int[s.length()];
        int index = 0, max = 0;
        for(int i = 1; i < s.length(); i++) {
            while(index > 0 && s.charAt(i) != s.charAt(index)) {
                index = table[index - 1];
            }
            if(s.charAt(i) == s.charAt(index)) {
                index += 1;
                table[i] = index;
                // table의 최댓값 갱신
                max = Math.max(max, table[i]);
            }
        }
        return max;
    }
}
