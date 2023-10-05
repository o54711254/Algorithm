import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] Cvisited;// combination에서 이용되는 방문배열
	static boolean[][] visited;
	static ArrayList<Integer>[] Sel = new ArrayList[3];
	static ArrayList<ArrayList<Integer>> zero = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int max;
	static int[][] tempMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					ArrayList<Integer> temp = new ArrayList<>();
					zero.add(temp);
					zero.get(idx).add(i);
					zero.get(idx).add(j);
					idx++;
				}
			}
		}
		Cvisited = new boolean[zero.size()];
		visited = new boolean[N][M];
//		System.out.println(Arrays.deepToString(map));
//		System.out.println(zero);
//		System.out.println(Arrays.deepToString(map));
		max = 0;
		combination(0);
		System.out.println(max);
	}

	public static void combination(int sidx) {
		// 기저조건
//		System.out.println(Arrays.deepToString(map));

		if (sidx == 3) {
			tempMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				tempMap[i] = map[i].clone();
			}
//			System.out.println(Arrays.toString(Sel));
			visited = new boolean[N][M];
//			System.out.println(Arrays.toString(Sel));
			for (int i = 0; i < 3; i++) {
				int[] temp = new int[2];
				int idx = 0;
				for (Integer s : Sel[i]) {
					temp[idx++] = s;
//					System.out.println(s);
				}
				tempMap[temp[0]][temp[1]] = 1;
			}
//			System.out.println(Arrays.deepToString(tempMap));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && tempMap[i][j] == 2) {
						DFS(i, j);
					}
				}
			}
//			System.out.println(Arrays.deepToString(visited));
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && tempMap[i][j] == 0) {
						cnt++;
					}
				}
			}
			if(max<cnt) {
				max = cnt;
			}
			return;
		}
		// 재귀조건
		for (int i = 0; i < zero.size(); i++) {
			if (!Cvisited[i]) {
				Cvisited[i] = true; // 방문했다 true
				Sel[sidx] = zero.get(i);
//				System.out.println(Arrays.toString(Cvisited));
				combination(sidx + 1);
				Cvisited[i] = false;
			}
		}
	}

	public static void DFS(int i, int j) {
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int px = i + dx[k];
			int py = j + dy[k];
			if (px >= 0 && py >= 0 && px < N && py < M && !visited[px][py] && tempMap[px][py] == 0) {
				DFS(px, py);
			}
		}
	}

}