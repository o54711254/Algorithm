import java.io.*;
import java.util.*;

class Spot implements Comparable<Spot> {
	int idx;
	int time;

	public Spot(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}

	@Override
	public int compareTo(Spot o) {
		return this.time - o.time;
	}
}

class Main {
	static int K;
	static int INF = 2000000000;
	static int[] result;
	static int[] path;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		result = new int[100001];
		path = new int[100001];
		Arrays.fill(result, INF);

		dijkstra(N);
		sb.append(result[K]).append("\n");
		findPath(N, K);

		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Spot> pq = new PriorityQueue<Spot>();
		pq.add(new Spot(start, 0));
		result[start] = 0;

		while (!pq.isEmpty()) {
			Spot now = pq.poll();

			if (now.idx == K) {
				return;
			}

			if (now.idx + 1 <= 100000 && result[now.idx + 1] > result[now.idx] + 1) {
				result[now.idx + 1] = result[now.idx] + 1;
				path[now.idx + 1] = now.idx;
				pq.add(new Spot(now.idx + 1, result[now.idx] + 1));
			}

			if (now.idx - 1 >= 0 && result[now.idx - 1] > result[now.idx] + 1) {
				result[now.idx - 1] = result[now.idx] + 1;
				path[now.idx - 1] = now.idx;
				pq.add(new Spot(now.idx - 1, result[now.idx] + 1));
			}

			if (now.idx * 2 <= 100000 && result[now.idx * 2] > result[now.idx] + 1) {
				result[now.idx * 2] = result[now.idx] + 1;
				path[now.idx * 2] = now.idx;
				pq.add(new Spot(now.idx * 2, result[now.idx] + 1));
			}

		}
	}

	static void findPath(int start, int destination) {
		int temp = destination;
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(temp);

		while (temp != start) {
			stack.add(path[temp]);
			temp = path[temp];
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
	}
}