import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			queue.add(num);
		}

		int result = 0;
		int num = 0;
		while (true) {
			if (queue.size() == 1) {
				break;
			}
			int first = queue.poll();
			int second = queue.poll();
			num = first + second;
			result += num;
			queue.add(num);
		}

		System.out.println(result);

	}
}