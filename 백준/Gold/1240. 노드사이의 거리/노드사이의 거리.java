import java.io.*;
import java.util.*;
import java.awt.*;

class Node {
	int num;
	int distance;

	public Node(int num, int distance) {
		this.num = num;
		this.distance = distance;
	}
}

class Root {
	int start;
	int end;

	public Root(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Main {
	static int N;
	static int M;

	static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(end, distance));
			list.get(end).add(new Node(start, distance));
		}

		sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(findDistance(start, end));
			sb.append("\n");
		}

		System.out.println(sb);

	}

	static int findDistance(int start, int end) {
		int result = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		fillArrMaxValue(arr);

		arr[start] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < list.get(now).size(); i++) {
				Node next = list.get(now).get(i);
				if (arr[next.num] > arr[now] + next.distance) {
					arr[next.num] = arr[now] + next.distance;
					if (next.num == end) {
						return arr[next.num];
					} else {
						queue.add(next.num);
					}
				}
			}
		}
		result = arr[end];

		return result;
	}

	static void fillArrMaxValue(int[] arr) {
		Arrays.fill(arr, Integer.MAX_VALUE);
	}
}