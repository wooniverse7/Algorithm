package BOJ.Season01.P10828;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main {
        public static int[] stack; // stack 전역 변수
        public static int idx = 0;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            stack = new int[N];

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); // 왜 for문 밖에서는 에러가 뜨는거지(NoSuchElementException = 가져올 토큰이 없다)
                String cmd = st.nextToken(); // 명령어부터 입력받음

                switch (cmd) {
                    case "push": // push를 입력받으면 data를 추가로 입력
                        push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop": // pop한 원소를 쌓음
                        sb.append(pop()).append('\n');
                        break;
                    case "size":
                        sb.append(size()).append('\n');
                        break;
                    case "empty":
                        sb.append(empty()).append('\n');
                        break;
                    case "top":
                        sb.append(top()).append('\n');
                        break;
                    default:
                        break;
                }

            }

            System.out.println(sb);
        }

        // data 삽입
        public static void push(int data){
            stack[idx] = data;
            idx += 1;
        }

        // data 삭제 및 출력
        public static int pop(){
            if(idx == 0) return -1;

            // 2개 원소라면 idx = 2, stack[2]는 3번 째 원소.
            int rst = stack[idx-1];
            stack[idx-1] = 0;
            idx--;

            return rst;
        }

        // stack 크기 출력
        public static int size(){
            return idx;
        }
        // 빈 stack인지 확인
        public static int empty(){
            if(idx == 0) return 1;

            return 0;
        }

        // 제일 위에 있는 원소 출력
        public static int top(){
            if(idx == 0) return -1;

            return stack[idx-1];
        }
    }