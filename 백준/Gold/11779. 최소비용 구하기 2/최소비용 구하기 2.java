import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
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

    @Override
    public int compareTo(Node o) {

        return this.w - o.w;
    }
}


class Main {
    static int n, m, start, end;
    static int INF = 2000000000;
    static int[] result;
    static int[] resultNode;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        result = new int[n + 1];
        resultNode = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            result[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(new Node(start, 0));

        Stack<Integer> stack = new Stack<>();
        int n = end;
        stack.add(n);
        while (true) {
            stack.add(resultNode[n]);
            n = resultNode[n];
            if (n == start) {
                break;
            }
        }
        sb = new StringBuilder();
        sb.append(result[end]).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }

    static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(start);
        result[start.v] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > result[now.v]) {
                continue;
            }
            for (int i = 0; i < graph.get(now.v).size(); i++) {
                Node next = graph.get(now.v).get(i);
                if (result[next.v] > result[now.v] + next.w) {
                    result[next.v] = result[now.v] + next.w;

                    resultNode[next.v] = now.v;
                    pq.add(next);
                }
            }
        }
    }

}