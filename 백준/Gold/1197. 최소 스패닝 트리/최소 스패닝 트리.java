import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int w;


    public Edge(int from, int to, int w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", w=" + w +
                '}';
    }
}

class Main {
    static ArrayList<Edge> edgeList;
    static int[] parents;
    static int V, E,sum, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();
        parents = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(A, B, C));
        }

        Kruscal();
        System.out.println(sum);
    }

    static void Kruscal() {
        Collections.sort(edgeList);

        for (int i = 0; i < E; i++) {
            int a = edgeList.get(i).from;
            int b = edgeList.get(i).to;
            if (union(a, b)) {
                sum += edgeList.get(i).w;
                count++;
            }
            if (count == V - 1) {
                break;
            }
        }
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        } else if (x != y) {
            parents[y] = x;
        }
        return true;
    }
}