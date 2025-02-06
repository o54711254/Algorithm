import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int result = 0;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		List<Character> charList = new ArrayList<>();
		solution(new Point(0, 0), charList);
		System.out.println(result);
	}

	static void solution(Point start, List<Character> charList) {
		charList.add(map[start.x][start.y]);
		result = Math.max(charList.size(), result);

		for (int i = 0; i < 4; i++) {
			int nr = start.x + dr[i];
			int nc = start.y + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
				continue;
			}

			if (charList.contains(map[nr][nc])) {
				result = Math.max(charList.size(), result);
			} else {
				solution(new Point(nr, nc), charList);
				charList.remove(charList.size() - 1);
			}
		}
	}

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