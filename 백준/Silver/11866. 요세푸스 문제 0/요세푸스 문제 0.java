
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		sb = new StringBuilder();
		sb.append("<");
		
		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			if (cnt == K) {
				sb.append(queue.poll()).append(",").append(" ");
				cnt = 0;
			} else {
				queue.offer(queue.poll());
			}

		}
		sb.replace(sb.length()-2, sb.length(), ">");
		System.out.println(sb);

	}
}
