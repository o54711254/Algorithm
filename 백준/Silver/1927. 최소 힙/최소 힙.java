import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int order = Integer.parseInt(br.readLine());
			if (order == 0) {
				if (pq.isEmpty()) {
					sb.append(0);
					sb.append("\n");
				} else {
					sb.append(pq.poll());
					sb.append("\n");
				}
			} else {
				pq.add(order);
			}
		}
		System.out.println(sb);
	}
}