import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static Integer[] crane;
	static List<Integer> box = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int max = 0;
		crane = new Integer[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
			max = Math.max(crane[i], max);
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > max) {
				System.out.println(-1);
				return;
			}
			box.add(num);
		}

		sort();

		int cnt = 0;
		while (!box.isEmpty()) {
			cnt++;

			for (int i = 0; i < N; i++) {
				int now = crane[i];
				for (int j = 0; j < box.size(); j++) {
					if (now >= box.get(j)) {
						box.remove(j);
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	private static void sort() {
		Arrays.sort(crane, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		Collections.sort(box, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

	}
}