package BOJ.Season01.P1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N+1];

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(str, i);
            arr[i] = str;
        }

//        for(Map.Entry<Integer, String> entry : map.entrySet()){
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            String tmp = br.readLine();
            if(isInt(tmp)){//입력값이 Integer(Key값)일 때
                int num = Integer.parseInt(tmp);
                sb.append(arr[num]).append('\n');
            }else{
                sb.append(map.get(tmp)).append('\n');
            }

        }
        System.out.println(sb);
    }

    static boolean isInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    // 제네릭 클래스, hashmap에 value로 key 찾기.
    // 리턴값 key, 매개변수 hashmap과 value
    public static <K, V> K getKey(HashMap<K, V> map, V value){
        for(K key : map.keySet()){
            if(value.equals(map.get(key))){
                return key;
            }
        }
        return null;
    }
}

// value를 통해 key값을 찾기 위해 hashmap을 전체탐색 하지 않고(시간 초과)
// 따로 String배열을 만들어 해당 idx의 String값을 찾아도 된다.