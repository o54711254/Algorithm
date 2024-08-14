import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int M;
	static boolean[] check;
	static int[] arr;
	static int[] tmp;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		tmp = new int[M];
		check = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		

		sb = new StringBuilder();
		
		permutation(0);

		System.out.println(sb);

	}

	static void permutation(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				tmp[depth] = arr[i];
				permutation(depth + 1);
				check[i] = false;
			}
		}
	}
}