import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visit;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (N == M) {
			System.out.println(0);
		} else {

			visit = new int[100001];
			bfs(N);
		}

	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visit[start] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = now + 1;
				} else if (i == 1) {
					next = now - 1;
				} else {
					next = 2 * now;
				}
				if (next < 0 || next > 100000 || visit[next] != 0) {
					continue;
				}
				queue.add(next);
				visit[next] = visit[now] + 1;
				if (next == M) {
					System.out.println(visit[next]);
					return;
				}
			}
		}
	}
}