import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Shark implements Comparable<Shark> {
    int r;
    int c;
    int dist;

    public Shark(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }

    @Override
    public int compareTo(Shark o) {
        if (this.dist == o.dist) {
            if (this.r == o.r) {
                return this.c - o.c;
            }
            return this.r - o.r;
        }
        return this.dist - o.dist;
    }
}

class Main {
    static int N, result;
    static int sr, sc, size, eat;
    static boolean flag;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sr = i;
                    sc = j;
                    map[i][j] = 0;
                }
            }
        }

        eat = 0;
        size = 2;
        result = 0;
        while (true) {
            flag = false;
            visit = new boolean[N][N];
            Shark now = new Shark(sr, sc, 0);
            bfs(now);
            if (!flag) {
                break;
            }
        }
        System.out.println(result);
    }

    static void bfs(Shark shark) {
        PriorityQueue<Shark> pq = new PriorityQueue<>();
        pq.add(shark);
        visit[shark.r][shark.c] = true;
        while (!pq.isEmpty()) {
            Shark now = pq.poll();
            if (map[now.r][now.c] != 0 && map[now.r][now.c] < size) {
                map[now.r][now.c] = 0;
                eat++;
                if (eat == size) {
                    size++;
                    eat = 0;
                }
                flag = true;
                sr = now.r;
                sc = now.c;
                result += now.dist;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] > size) {
                    continue;
                }
                pq.add(new Shark(nr, nc, now.dist + 1));
                visit[nr][nc] = true;
            }
        }
    }
}