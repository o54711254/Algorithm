import java.awt.*;
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
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class Main {
    static int N, M;
    static int result = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[][] map;
    static ArrayList<CCTV> cctvList = new ArrayList<>();

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
                // 만약 0이 아니고 6(벽)이 아니면 cctv 이므로 넣어줌
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0);

        System.out.println(result);

    }

    static void dfs(int depth) {
        // cctv의 갯수
        int size = cctvList.size();

        if (depth == size) {
            // check 메서드로 경우의 수 별 사각지대의 갯수를 구하고 최솟값을 구함
            result = Math.min(result, check());
            return;
        }

        // 복사용 copy배열
        int[][] copy = new int[N][M];

        CCTV now = cctvList.get(depth);
        // cctv의 타입에 따라
        switch (now.type) {
            case 1:
                // dir은 방향, 1번 카메라는 4개의 경우의 수
                for (int dir = 0; dir < 4; dir++) {
                    copy(map, copy);
                    move(now, dir);
                    dfs(depth + 1);
                    copy(copy, map);
                }
                break;
            case 2:
                for (int dir = 0; dir < 2; dir++) {
                    copy(map, copy);
                    move(now, dir);
                    move(now, (dir + 2) % 4);
                    dfs(depth + 1);
                    copy(copy, map);
                }
                break;
            case 3:
                for (int dir = 0; dir < 4; dir++) {
                    copy(map, copy);
                    move(now, dir);
                    move(now, (dir + 1) % 4);
                    dfs(depth + 1);
                    copy(copy, map);
                }
                break;
            case 4:
                for (int dir = 0; dir < 4; dir++) {
                    copy(map, copy);
                    move(now, dir);
                    move(now, (dir + 1) % 4);
                    move(now, (dir + 2) % 4);
                    dfs(depth + 1);
                    copy(copy, map);
                }
                break;
            case 5:
                copy(map, copy);
                for (int dir = 0; dir < 4; dir++) {
                    move(now, dir);
                }
                dfs(depth + 1);
                copy(copy, map);
                break;
        }

    }

    static void move(CCTV c, int dir) {
        int nr = c.x;
        int nc = c.y;
        while (true) {
            nr = nr + dr[dir];
            nc = nc + dc[dir];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6) {
                break;
            }
            map[nr][nc] = -1;
        }
    }

    static void copy(int[][] map, int[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    static int check() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    // 확인용 print
    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}