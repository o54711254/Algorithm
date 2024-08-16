import java.io.*;
import java.util.*;

class Archor {
    int r;
    int c;

    public Archor(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "r : " + r + " " + "c : " + c;
    }
}

class Main {
    static int[] dr = { -1, 0, 0 };
    static int[] dc = { 0, -1, 1 };
    static int N, M, D;
    static int number;
    static int result = 0;
    static Archor[] archorPoint;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        archorPoint = new Archor[3];

        locate(0, 0);

        System.out.println(result);
    }

    // 궁수 배치(조합)
    static void locate(int depth, int start) {
        if (depth == 3) {
            int[][] copyMap = copyMap(map);
            number = 0;
            simulate();
            result = Math.max(result, number);
            map = copyMap;
            return;
        }

        for (int i = start; i < M; i++) {
            archorPoint[depth] = new Archor(N, i);
            locate(depth + 1, i + 1);
        }
    }

    // 시뮬레이션
    static void simulate() {
        int turn = 0;
        while (turn < N) {
            List<int[]> targets = new ArrayList<>();
            for (Archor archor : archorPoint) {
                int[] target = attack(archor);
                if (target != null) {
                    targets.add(target);
                }
            }
            for (int[] target : targets) {
                if (map[target[0]][target[1]] == 1) {
                    map[target[0]][target[1]] = 0;
                    number++;
                }
            }
            down();
            turn++;
        }
    }

    // 적 찾기
    static int[] attack(Archor archor) {
        for (int d = 1; d <= D; d++) {
            for (int y = archor.c - d + 1; y < archor.c + d; y++) {
                int x = archor.r - (d - Math.abs(y - archor.c));
                if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] == 1) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    // 적 내려오기
    static void down() {
        for (int i = N - 1; i > 0; i--) {
            map[i] = map[i-1].clone();
        }
        Arrays.fill(map[0], 0);
    }

    static int[][] copyMap(int[][] map) {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            result[i] = map[i].clone();
        }
        return result;
    }
}