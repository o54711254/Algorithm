import java.util.*;
import java.io.*;

public class Main {
    static int N = 9;
    static int[][] map = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            char[] numbers = str.toCharArray();
            for (int j = 1; j <= N; j++) {
                map[i][j] = numbers[j - 1] - '0';
            }
        }
        search(map, 1, 1, 0);
    }

    static boolean search(int[][] testMap, int r, int c, int depth) {

        if (depth == 81) {
            print();
            return true;
        }

        if (testMap[r][c] != 0) {
            if (c == 9) {
                if (search(testMap, r + 1, 1, depth + 1)) return true;
            } else {
                if (search(testMap, r, c + 1, depth + 1)) return true;
            }
            return false;
        }

        for (int i = 1; i <= 9; i++) {
            if (isValid(testMap, r, c, i)) {
                testMap[r][c] = i;
                if (c == 9) {
                    if (search(testMap, r + 1, 1, depth + 1)) return true;
                } else {
                    if (search(testMap, r, c + 1, depth + 1)) return true;
                }
                testMap[r][c] = 0; // 백트래킹
            }
        }
        return false;
    }

    static boolean isValid(int[][] testMap, int r, int c, int num) {
        for (int i = 1; i <= 9; i++) {
            if (testMap[r][i] == num || testMap[i][c] == num) return false;
        }

        int startRow = (r - 1) / 3 * 3 + 1;
        int startCol = (c - 1) / 3 * 3 + 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (testMap[startRow + i][startCol + j] == num) return false;
            }
        }
        return true;
    }

    static void print() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}