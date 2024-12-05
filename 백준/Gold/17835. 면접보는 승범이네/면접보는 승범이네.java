import java.io.*;
import java.util.*;

class Root implements Comparable<Root> {
	int spot;
	int distance;

	public Root(int spot, int distance) {
		this.spot = spot;
		this.distance = distance;
	}

	@Override
	public int compareTo(Root o) {
		return this.distance - o.distance;
	}
}

class Main {
	static int N, M, K;
	static final long INF = Long.MAX_VALUE;
	static long[] distanceArr;
	static int[] spotArr;
	static List<List<Root>> rootList = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		distanceArr = new long[N + 1];
		spotArr = new int[K];

		for (int i = 0; i <= N; i++) {
			rootList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			rootList.get(v).add(new Root(u, c));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			spotArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(distanceArr, INF);
		for (int i = 0; i < K; i++) {
			dijkstra(spotArr[i]);
		}

		findResult();
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Root> pq = new PriorityQueue<Root>();
		pq.add(new Root(start, 0));

		// 각 면접장마다 자신의 거리는 0으로 초기화
		distanceArr[start] = 0;

		while (!pq.isEmpty()) {
			Root now = pq.poll();

			if (now.distance > distanceArr[now.spot])
				continue;

			for (int i = 0; i < rootList.get(now.spot).size(); i++) {
				Root next = rootList.get(now.spot).get(i);

				if (distanceArr[next.spot] > distanceArr[now.spot] + next.distance) {
					distanceArr[next.spot] = distanceArr[now.spot] + next.distance;
					pq.add(new Root(next.spot, (int) distanceArr[next.spot]));
				}
			}
		}
	}

	static void findResult() {
		int index = 0;
		long result = 0;

		for (int i = 1; i <= N; i++) {
			if (distanceArr[i] > result) {
				result = distanceArr[i];
				index = i;
			}
		}

		sb.append(index).append("\n").append(result);
	}
}