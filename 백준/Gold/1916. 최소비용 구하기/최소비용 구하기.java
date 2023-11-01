import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int start, end;
	static int[][] map;
	static long[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		// 초기화
		// 비용이 0보다 크거나 같으므로
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int go = Integer.parseInt(st.nextToken()); // 출발 번호
			int stop = Integer.parseInt(st.nextToken()); // 도착 번호
			int pay = Integer.parseInt(st.nextToken()); // 비용
			
			// 같은 경로이면 비용이 더 적은걸로
			map[go][stop] = Math.min(map[go][stop], pay);

		} // 입력 끝

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		arr = new long[N + 1]; // 최소 비용을 저장할 배열
		Arrays.fill(arr, Integer.MAX_VALUE); // 배열을 최댓값으로 채우기
		arr[start] = 0; // 출발점은 0으로
		visited = new boolean[N + 1];
		int cnt = 0;

		while (cnt < N) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int i = 0; i < N + 1; i++) {
				if (!visited[i] && (arr[i] < min)) {
					min = (int) arr[i];
					idx = i;
				}
			}
			
			visited[idx] = true;
			for (int i = 0; i < N + 1; i++) {
				if (!visited[i] && map[idx][i] != Integer.MAX_VALUE && (arr[idx] + map[idx][i]) < arr[i]) {
					arr[i] = arr[idx] + map[idx][i];
				}
			}

			cnt++;

		}

		System.out.println(arr[end]);

	}// main

}