import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dx = { 0, 1, 1 }; // k는 0일때 가로 //k는 1일때 세로 //k는 2일때 대각선
	static int[] dy = { 1, 0, 1 };
	static boolean[][] visited;
	static int N;
	static int type;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(map));
		cnt = 0;
		DFS(0,1,0);
		System.out.println(cnt);
	}

	public static void DFS(int i, int j, int K) {
		visited[i][j] = true;
		
		if(i==N-1&&j==N-1) {
			cnt++;
		}
		
		for (int k = 0; k < 3; k++) {
			int px = -1; int py = -1;
			if (K == 0 && (k == 0 || k == 2)) {
				px = i + dx[k];
				py = j + dy[k];
				type = k;
			} else if (K == 1 && (k == 1 || k == 2)) {
				px = i + dx[k];
				py = j + dy[k];
				type = k;
			} else if (K == 2) {
				px = i + dx[k];
				py = j + dy[k];
				type = k;
			}
			if (type==2&&px >= 0 && py >= 0 && px < N && py < N && !visited[px][py] && map[px][py] == 0&&map[px][py-1] == 0&&map[px-1][py] == 0) {
				DFS(px,py,type);
			}else if ((type==0||type==1)&&px >= 0 && py >= 0 && px < N && py < N && !visited[px][py] && map[px][py] == 0) {
				DFS(px,py,type);
			}

		}
		visited[i][j] = false;
	}
}