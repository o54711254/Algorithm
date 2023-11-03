import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static long[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		nums = new long[N + 1]; // 동물의 수를 저장할 배열
		list = new ArrayList<>(); // 간선을 저장할 리스트
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 2; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			String ani = st.nextToken();
			int mari = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			list.get(n).add(i); // n번 노드에 노드 i번 넣기, 단방향으로 넣어줘도 충분

			if (ani.equals("W"))
				mari *= -1; // 늑대이면 마릿수를 음수로 넣기
			nums[i] = mari; // nums 배열에 동물의 수 저장

		}

		dfs(1, -1);
		System.out.println(nums[1]);

	}// main

	static void dfs(int bottom, int up) {
		// 먼저 노드 끝까지 들어가
		for (int x : list.get(bottom)) {
			// bottom 이였던 애가 이제는 up이 됨
			dfs(x, bottom);
		}

		if (up != -1) {
			if (nums[bottom] > 0) {
				nums[up] += nums[bottom];
			}
		}

	}// dfs

}