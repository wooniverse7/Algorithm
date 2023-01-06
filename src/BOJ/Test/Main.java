package BOJ.Test;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String str = "banana";

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(hm.containsKey(c)){
                int cnt = hm.get(c);
                hm.put(c, ++cnt);
            }
            else hm.put(c, 1);
        }

        System.out.println(hm);
    }
}
