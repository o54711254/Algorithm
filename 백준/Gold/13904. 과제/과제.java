import java.util.*;
import java.io.*;

class Homework implements Comparable<Homework> {
	int d;
	int w;

	public Homework(int d, int w) {
		this.d = d;
		this.w = w;
	}

	@Override
	public int compareTo(Homework o) {
		return o.w - this.w;
	}

	@Override
	public String toString() {
		return "d : " + d + " " + " w : " + w + "\n";
	}
}

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		PriorityQueue<Homework> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());
		int size = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			size = Math.max(d, size);
			pq.add(new Homework(d, w));
		}

		Integer[] arr = new Integer[size + 1];
		int result = 0;
		while (!pq.isEmpty()) {
			Homework now = pq.poll();
			int nowD = now.d;
			int nowW = now.w;

			for (int i = nowD; i > 0; i--) {
				if (arr[i] == null) {
					arr[i] = nowW;
					result += nowW;
					break;
				}
			}

		}
		System.out.println(result);

	}
}