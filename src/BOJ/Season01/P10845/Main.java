package BOJ.Season01.P10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] queue;
    public static int fst = 0; // 큐의 원소가 있는 처음 인덱스
    public static int lst = 0; // 큐의 마지막 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        queue = new int[N+1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }

    public static void push(int data){
        queue[lst] = data;
        lst++;
    }

    // 1 3 5 -> idx = 3, 마지막 idx = 2
    // push(1) -> idx = 1, pop -> reduce(1, 1)
    public static int pop(){
        // 처음과 마지막 원소 인덱스가 겹친다 = 없다
        if(lst - fst == 0) return -1;

        int rst = queue[fst];
        queue[fst] = 0; // 안해도 된다.
        fst++; // 원소 시작 idx를 증가시킴

        return rst;
    }

    //push push push push pop pop -> lst = 4, fst = 2 -> 2
    public static int size(){
        return lst - fst;
    }

    public static int empty(){
        if(lst - fst == 0) return 1;

        return 0;
    }

    public static int front(){
        if(lst - fst == 0) return -1;

        return queue[fst];
    }

    public static int back(){
        if(lst - fst == 0) return -1;

        // 시작위치가 아닌 원소 마지막 위치
        return queue[lst-1];
    }
}
