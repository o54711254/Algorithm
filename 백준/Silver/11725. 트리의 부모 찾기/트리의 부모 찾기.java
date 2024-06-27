import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<List<Integer>> list;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		N = Integer.parseInt(br.readLine());

		// 그래프 생성
		list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		// 배열 선언
		result = new int[N + 1];
		bfs(1);

		sb = new StringBuilder();

		for (int i = 2; i < N + 1; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb);

	}

	static void bfs(int start) {
		for (int i = 0; i < list.get(start).size(); i++) {
			int num = list.get(start).get(i);
			if (result[num] == 0) {
				result[num] = start;
				bfs(num);
			}
		}

	}
}