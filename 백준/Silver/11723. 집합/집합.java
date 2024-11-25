import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int N = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[21];

		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				arr[num] = true;
			} else if (order.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				arr[num] = false;
			} else if (order.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if (arr[num]) {
					sb.append(1);
					sb.append("\n");
				} else {
					sb.append(0);
					sb.append("\n");
				}
			} else if (order.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				arr[num] = !arr[num];
			} else if (order.equals("all")) {
				Arrays.fill(arr, true);
			} else if (order.equals("empty")) {
				Arrays.fill(arr, false);
			}
		}
		System.out.println(sb);
	}
}