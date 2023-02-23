package SKP2023.p2;

public class Main {
    public static void main(String[] args) {
        int[] p1 = {2, 2, -1, 1, 5, -1, 5};

        int[] b1 = {2, 5};
        int[] b2 = {1, 5};

        System.out.println(solution(p1, b1)); // (4, 3)
        System.out.println(solution(p1, b2)); // (0, 3)
    }

    public static int[] solution(int[] p, int[] b) {
        int[] answer = {};

        // -1 개수만큼 Array만들기? -> 귀찮음
        // 어레이를 만들어서 재귀를 탄다?
        // b[0]부터 하나씩 구현해보자.
        int tmp = 0;
        for (int i = 0; i < p.length; i++) {
            if(p[i] == -1) tmp++;
        }
        int[] size = new int[tmp];


        return answer;
    }
}
