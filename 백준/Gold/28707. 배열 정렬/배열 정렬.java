import java.io.*;
import java.util.*;

/*
 * 1. 오름차순 체크 메서드
 * 2. 순서 바꾸는 메서드 
 * 3. dfs 로 찾기 
 * */

class Path {
	int start;
	int end;
	int cost;

	public Path(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

class Value implements Comparable<Value> {
	int[] numbers;
	int cost;

	public Value(int[] numbers, int cost) {
		this.numbers = numbers;
		this.cost = cost;
	}

	@Override
	public int compareTo(Value o) {
		return this.cost - o.cost;
	}

	@Override
	public String toString() {
		return "numbers : " + numbers + " cost : " + cost;
	}
}

class Main {
	static int N, M, result;
	static final int INF = Integer.MAX_VALUE;

	static int[] arr;

	static List<Path> pathList = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			pathList.add(new Path(start, end, cost));
		}

		result = INF;
		dijkstra(new Value(arr, 0));
		System.out.println(result == INF ? -1 : result);
	}

	static void dijkstra(Value start) {
		PriorityQueue<Value> pq = new PriorityQueue<Value>();
		pq.add(start);

		while (!pq.isEmpty()) {

			Value now = pq.poll();

			if (checkNumbers(now.numbers)) {
				result = Math.min(result, now.cost);
				return;
			}

			int[] numbers = now.numbers;
			int cost = now.cost;

			for (int i = 0; i < M; i++) {
				Path path = pathList.get(i);

				int[] next = change(numbers, path);
				int nextNumber = getNumber(next);
				int nextCost = cost + path.cost;

				if (map.containsKey(nextNumber) && map.get(nextNumber) > nextCost) {
					map.replace(nextNumber, nextCost);
					pq.add(new Value(next, nextCost));
				} else if (!map.containsKey(nextNumber)) {
					map.put(nextNumber, nextCost);
					pq.add(new Value(next, nextCost));
				}

			}
		}
	}

	static int[] change(int[] numbers, Path path) {
		int[] next = Arrays.copyOf(numbers, N);

		int start = path.start;
		int end = path.end;

		int temp = next[start];
		next[start] = next[end];
		next[end] = temp;

		return next;
	}

	static boolean checkNumbers(int[] arr) {
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static int getNumber(int[] numbers) {
		sb = new StringBuilder();
		for (int num : numbers) {
			sb.append(num);
		}
		return Integer.parseInt(sb.toString());
	}
}