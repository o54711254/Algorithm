import java.util.*;
import java.io.*;

class Main {

	private static class Conf implements Comparable<Conf> {
		private final int start;
		private final int end;

		public Conf(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Conf o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		PriorityQueue<Conf> pq = new PriorityQueue<>();

		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			pq.add(new Conf(start, end));
		}

		int count = 0;
		int lastEndTime = 0;

		while (!pq.isEmpty()) {
			Conf now = pq.poll();
			if (now.start >= lastEndTime) {
				lastEndTime = now.end;
				count++;
			}
		}

		System.out.println(count);
	}

}