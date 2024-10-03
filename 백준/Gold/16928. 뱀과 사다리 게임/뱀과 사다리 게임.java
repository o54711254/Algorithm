import java.io.*;
import java.util.*;

/*
 * dp 집합에 최소한으로 갈 수 있는 주사위 수 저장 
 * 재귀를 돌며 1~6까지 경우의수 계속 탐방 
 * 만약 수가 뱀 or 사다리가 있는 수이면 그 수로 이동 
 * 뱀 or 사다리는 Map or ArrayList에 저장 
 * Map 하나만 쓰고 key, value 순으로 저장
 * 
 * */

public class Main {
	static int[] dp = new int[101];
	static int N, M;
	static Map<Integer, Integer> bridge = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			bridge.put(x, y);
		}

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		move(1, 0);

		System.out.println(dp[100]);
	}

	static void move(int number, int count) {

		if (number > 100) {
			return;
		}

		// 주사위 수 만
		for (int i = 1; i <= 6; i++) {
			int next = number + i;
			if (bridge.containsKey(next)) {
				next = bridge.get(next);
			}

			if (next <= 100 && dp[next] > (count + 1)) {
				dp[next] = count + 1;
				move(next, count + 1);
			}
		}

	}

}