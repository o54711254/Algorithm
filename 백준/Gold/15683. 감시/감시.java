import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV {
    int x;
    int y;
    int type;

    public CCTV(int x, int y, int type) {
        super();
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class Main {
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int[][] map;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static ArrayList<CCTV> cctvList = new ArrayList<CCTV>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int depth) {
        if (depth == cctvList.size()) {
            min = Math.min(min, check());
            return;
        }

        CCTV c = cctvList.get(depth);
        int copy[][] = new int[N][M];

        switch (c.type) {
            case 1:
                for (int dir = 0; dir < 4; dir++) {
                    copyMap(copy, map);
                    watch(c.x, c.y, dir);
                    dfs(depth + 1);
                    copyMap(map, copy);
                }
                break;
            case 2:
                for (int dir = 0; dir < 2; dir++) {
                    copyMap(copy, map);
                    watch(c.x, c.y, dir);
                    watch(c.x, c.y, dir + 2);
                    dfs(depth + 1);
                    copyMap(map, copy);
                }
                break;
            case 3:
                for (int dir = 0; dir < 4; dir++) {
                    copyMap(copy, map);
                    watch(c.x, c.y, dir);
                    watch(c.x, c.y, (dir + 1) % 4);
                    dfs(depth + 1);
                    copyMap(map, copy);
                }
                break;
            case 4:
                for (int dir = 0; dir < 4; dir++) {
                    copyMap(copy, map);
                    watch(c.x, c.y, dir);
                    watch(c.x, c.y, (dir + 1) % 4);
                    watch(c.x, c.y, (dir + 2) % 4);
                    dfs(depth + 1);
                    copyMap(map, copy);
                }
                break;
            case 5:
                for (int dir = 0; dir < 4; dir++) {
                    copyMap(copy, map);
                    watch(c.x, c.y, dir);
                }
                dfs(depth + 1);
                copyMap(map, copy);
                break;
        }
    }

    static void watch(int x, int y, int dir) {
        while (true) {
            x += dr[dir];
            y += dc[dir];
            if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 6) {
                break;
            }
            if (map[x][y] == 0) {
                map[x][y] = -1;
            }
        }
    }

    static int check() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    static void copyMap(int[][] dest, int[][] src) {
        for (int i = 0; i < N; i++) {
            dest[i] = src[i].clone();
        }
    }
}