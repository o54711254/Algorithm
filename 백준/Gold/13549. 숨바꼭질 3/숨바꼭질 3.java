import java.io.*;
import java.util.*;

class Spot implements Comparable<Spot> {
	int index;
	int time;

	public Spot(int index, int time) {
		this.index = index;
		this.time = time;
	}

	@Override
	public int compareTo(Spot o) {
		return this.time - o.time;
	}
}

class Main {
	static int result[] = new int[100001];
	static final int INF = 2000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Arrays.fill(result, INF);

		bfs(N);

		System.out.println(result[K]);

	}

	static void bfs(int start) {
		PriorityQueue<Spot> pq = new PriorityQueue<Spot>();
		result[start] = 0;
		pq.add(new Spot(start, 0));

		while (!pq.isEmpty()) {
			Spot now = pq.poll();

			if (now.index + 1 <= 100000 && result[now.index + 1] > (now.time + 1)) {
				result[now.index + 1] = now.time + 1;
				pq.add(new Spot(now.index + 1, now.time + 1));
			}

			if (now.index - 1 >= 0 && result[now.index - 1] > (now.time + 1)) {
				result[now.index - 1] = now.time + 1;
				pq.add(new Spot(now.index - 1, now.time + 1));
			}

			if (now.index * 2 <= 100000 && result[now.index * 2] > now.time) {
				result[now.index * 2] = now.time;
				pq.add(new Spot(now.index * 2, now.time));
			}
		}
	}
}