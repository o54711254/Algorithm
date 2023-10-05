import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
    int x;
    int y;
    int z;

    public Tree(int x, int y, int z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;

    }

    @Override
    public String toString() {
        return "Tree [x=" + x + ", y=" + y + ", z=" + z + "]";
    }

    @Override
    public int compareTo(Tree o) {
        // TODO Auto-generated method stub
        return this.z - o.z;
    }
}

public class Main {
    static int N, M, K;
    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int[][] map;
    static int[][] nutrient;
    static ArrayList<Tree> tree;
    static ArrayList<Tree> alive;
    static ArrayList<Tree> dead;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = 5;
            }
        }

        // 겨울의 영양분
        nutrient = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                nutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tree = new ArrayList<>();
        alive = new ArrayList<>();
        dead = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            tree.add(new Tree(x, y, z));
        }

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(tree.size());

    }

    static void spring() {
        alive.clear();
        Collections.sort(tree);
        for (int i = 0; i < tree.size(); i++) {
            if (map[tree.get(i).x][tree.get(i).y] < tree.get(i).z) {
                dead.add(new Tree(tree.get(i).x, tree.get(i).y, tree.get(i).z));

            } else {
                map[tree.get(i).x][tree.get(i).y] -= tree.get(i).z;
                tree.get(i).z++;
                alive.add(new Tree(tree.get(i).x, tree.get(i).y, tree.get(i).z));
            }
        }
        tree.clear();
        for (int i = 0; i < alive.size(); i++) {
            tree.add(alive.get(i));
        }
    }

    static void summer() {
        for (int i = 0; i < dead.size(); i++) {
            map[dead.get(i).x][dead.get(i).y] += dead.get(i).z / 2;
        }
        dead.clear();
    }

    static void fall() {
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).z % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nr = tree.get(i).x + dr[j];
                    int nc = tree.get(i).y + dc[j];
                    if (nr < 1 || nc < 1 || nr >= N + 1 || nc >= N + 1) {
                        continue;
                    }
                    tree.add(new Tree(nr, nc, 1));
                }
            }
        }
    }

    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += nutrient[i][j];
            }
        }
    }

 
}