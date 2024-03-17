import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
	int start;
	int end;

	public Lecture(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Lecture o) {
		if (this.start == o.start) {
			return this.end - o.end;
		}
		return this.start - o.start;
	}

	@Override
	public String toString() {
		return "Lecture [start=" + start + ", end=" + end + "]";
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Lecture> list = new ArrayList<Lecture>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Lecture(start, end));
		}

		Collections.sort(list);
		for (Lecture lecture : list) {
			if (!pq.isEmpty() && pq.peek() <= lecture.start) {
				pq.poll();
			}
			pq.add(lecture.end);
		}

		System.out.println(pq.size());
	}
}