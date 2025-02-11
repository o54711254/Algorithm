import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (find(u) == find(v)) {
				System.out.println(i + 1);
				return;
			} else {
				union(u, v);
			}
		}
		System.out.println(0);
	}

	static int find(int num) {
		if (parents[num] == num) {
			return num;
		}

		return parents[num] = find(parents[num]);
	}

	static void union(int u, int v) {

		u = find(u);
		v = find(v);

		parents[v] = u;
	}
}