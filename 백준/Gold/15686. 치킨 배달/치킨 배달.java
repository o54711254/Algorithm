import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<Point> house;
	static ArrayList<Point> chicken;
	static int ans;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					house.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		ans = Integer.MAX_VALUE;
		check = new boolean[chicken.size()];
		
		dfs(0, 0);
		System.out.println(ans);

	}

	static void dfs(int start, int depth) {
		if (depth == M) {
			int result = 0;

			for (int i = 0; i < house.size(); i++) {
				int temp = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (check[j]) {
						int distance = Math.abs(house.get(i).x - chicken.get(j).x)
								+ Math.abs(house.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, distance);
					}
				}
				result += temp;
			}
			ans = Math.min(ans, result);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			check[i] = true;
			dfs(i + 1, depth + 1);
			check[i] = false;

		}
	}
}