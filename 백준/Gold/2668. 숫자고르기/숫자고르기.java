import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visit;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		visit = new boolean[N + 1];
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			visit[i] = true;
			solution(i, i);
			visit[i] = false;
		}

		sb = new StringBuilder();
		Collections.sort(list);
		int size = list.size();
		sb.append(size).append("\n");
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb);
	}

	private static void solution(int now, int start) {
		if (arr[now] == start) {
			list.add(start);
			return;
		}

		if (!visit[arr[now]]) {
			visit[arr[now]] = true;
			solution(arr[now], start);
			visit[arr[now]] = false;
		}
	}
}