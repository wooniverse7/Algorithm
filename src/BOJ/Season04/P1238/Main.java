package BOJ.Season04.P1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = Integer.MAX_VALUE;
    static List<ArrayList<Node>> list = new ArrayList<>();
    static List<ArrayList<Node>> backList = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int roadNum;
        int time;

        public Node(int roadNUm, int time){
            this.roadNum = roadNUm;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


    }
}
