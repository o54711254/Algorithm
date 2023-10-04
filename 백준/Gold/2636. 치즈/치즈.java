import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] cheese;
	static int cnt = 0; // 치즈개수를 셀 count
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 모양판의 세로
		M = Integer.parseInt(st.nextToken()); // 모양판의 가로
		map = new int[N][M]; // 모양판
		visited = new boolean[N][M];// 방문체크
		cheese = new boolean[N][M];// 녹을치즈체크

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(map));
//		for(int i=0; i<N; i++) {
//			System.out.println();
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//		}
		int DFScount = 0;
		while (true) {
			++DFScount;
			DFS(0, 0);
			int cheeseCount = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j]) {
						map[i][j] = 0;
						cheeseCount++;
//						System.out.println(cheeseCount);
					}
				}
			}
//			for(int i=0; i<N; i++) {
//				System.out.println();
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//			}
			list.add(cnt);
			if (cheeseCount == 0) {
				System.out.println(DFScount-1);
				System.out.println(list.get(list.size()-2));
				break;
			}
			
			cnt = 0;
			cheese =  new boolean[N][M];
			visited = new boolean[N][M];
		}
	}

	public static void DFS(int i, int j) {
		int x = i;
		int y = j;
		visited[x][y] = true;
//		System.out.println("x : " + x + " y : " + y);
		for (int k = 0; k < 4; k++) {
			int px = x + dx[k];
			int py = y + dy[k];
			if (px >= 0 && py >= 0 && px < N && py < M && !visited[px][py] && map[px][py] == 0) {
//				visited[px][py] = true; // 방문했다.
				DFS(px, py);
//				visited[px][py] = false; // 방문해제
			} else if (px >= 0 && py >= 0 && px < N && py < M && !cheese[px][py] && map[px][py] == 1) {// 겉치즈에 도착했다
				cheese[px][py] = true;
				cnt++;
			}

		}
//		visited[x][y] = false;
	}
}