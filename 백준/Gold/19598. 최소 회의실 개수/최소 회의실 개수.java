import java.util.*;
import java.io.*;

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
		return "start : " + start + "\n" + "end : " + end;

	}
}

public class Main {
	static List<Lecture> lectureList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		lectureList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			pq.add(end);
			lectureList.add(new Lecture(start, end));
		}

		Collections.sort(lectureList);

		for (int i = 0; i < N; i++) {
			Lecture lecture = lectureList.get(i);

			int firstEndTime = pq.peek();
			if (lecture.start >= firstEndTime) {
				pq.poll();
			}
		}

		System.out.println(pq.size());
	}
}