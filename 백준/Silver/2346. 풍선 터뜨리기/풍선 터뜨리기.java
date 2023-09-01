import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		Deque<Integer> deque = new ArrayDeque<Integer>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		int[] move = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}

		sb = new StringBuilder();
		while (deque.size()>1) {
			int index = deque.peek();
			sb.append(deque.poll()+" ");
			if (move[index - 1] > 0) {
				for (int i = 0; i < move[index - 1] - 1; i++) {
					deque.addLast(deque.pollFirst());
				}
			} else {
				for (int i = 0; i < Math.abs(move[index-1]); i++) {
					deque.addFirst(deque.pollLast());
				}
			}

		}
		sb.append(deque.peek());
		System.out.println(sb);
	}
}
