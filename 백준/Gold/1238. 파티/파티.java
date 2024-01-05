import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }
}


class Main {
    static int N, M, K;
    static int INF = 200000000;
    static int[] village;
    static int[] result;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        result = new int[N + 1];
        village = new int[N + 1];
        reset();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        dijkstra(new Node(1, 0));

        for (int i = 1; i < N + 1; i++) {
            reset();
            dijkstra(new Node(i, 0));
            result[i] = village[K];
        }

        reset();

        dijkstra(new Node(K, 0));
        for (int i = 1; i < N + 1; i++) {
            result[i] += village[i];
        }

        Arrays.sort(result);

        System.out.println(result[N]);
    }

    private static void reset() {
        for (int i = 0; i < N + 1; i++) {
            village[i] = INF;
            graph.add(new ArrayList<>());
        }
    }

    static void dijkstra(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        village[start.v] = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < graph.get(now.v).size(); i++) {
                Node next = graph.get(now.v).get(i);
                if (village[next.v] > village[now.v] + next.w) {
                    village[next.v] = village[now.v] + next.w;
                    queue.add(next);
                }
            }
        }
    }


}