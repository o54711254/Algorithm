import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int map[][];
    static int dr[] = { 0, 1, 0, -1 };
    static int dc[] = { 1, 0, -1, 0 };
    static int dist[][];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(new Point(0, 0));

        System.out.println(dist[N - 1][N - 1]);
    }

    public static void bfs(Point p) {
        Deque<Point> deque = new LinkedList<>();
        deque.addFirst(p);
        dist[p.x][p.y] = 0;

        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nr = now.x + dr[i];
                int nc = now.y + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                int cost = (map[nr][nc] == 1) ? 0 : 1;
                if (dist[nr][nc] > dist[now.x][now.y] + cost) {
                    dist[nr][nc] = dist[now.x][now.y] + cost;
                    if (cost == 0) {
                        deque.addFirst(new Point(nr, nc));
                    } else {
                        deque.addLast(new Point(nr, nc));
                    }
                }
            }
        }
    }
}