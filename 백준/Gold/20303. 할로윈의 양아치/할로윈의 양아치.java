import java.io.*;
import java.util.*;

/*
 * 1. 친구로 이루어진 트리 몇개 나오는지 구하기 
 * 2. 친구 수, 가치로 이루어진 Class 하나 만들어서 List로 관리 
 * 3. dp배열을 만들고 크기는 K로 한 다음 dp[K-1]을 구하면 정답임
 * 4. dp 의미는 dp[1] K가 1일 때 가장 큰 수 dp[2]는 K가 2일때 가장 큰수 이런식으로 ㄱㄱ */

class Friend {
	int cnt;
	int worth;

	public Friend(int cnt, int worth) {
		this.cnt = cnt;
		this.worth = worth;
	}

	@Override
	public String toString() {

		return "cnt : " + cnt + " worth : " + worth + "\n";
	}
}

class Main {
	static int N, M, K;

	static int[] candy;
	static int[] dp;
	static boolean[] visit;

	static List<List<Integer>> childList = new ArrayList<>();
	static List<Friend> friendList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		candy = new int[N + 1];
		visit = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= N; i++) {
			childList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			childList.get(from).add(to);
			childList.get(to).add(from);
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				bfs(i);
			}
		}

		dp = new int[K];
		knapsack();
		
		System.out.println(dp[K-1]);
	}

	static void knapsack() {
		for (Friend friend : friendList) {
			int cnt = friend.cnt;
			int worth = friend.worth;
			for (int i = K - 1; i >= cnt; i--) {
				dp[i] = Math.max(dp[i], dp[i - cnt] + worth);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start] = true;

		int number = 1;
		int worth = candy[start];

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < childList.get(now).size(); i++) {
				int next = childList.get(now).get(i);
				if (!visit[next]) {
					visit[next] = true;
					number++;
					worth += candy[next];
					queue.add(next);
				}
			}
		}
		friendList.add(new Friend(number, worth));
	}
}