import java.io.*;
import java.util.*;

class ConferenceTime implements Comparable<ConferenceTime> {
	int start;
	int end;

	public ConferenceTime(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(ConferenceTime o) {
		if (this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "start : " + start + " end : " + end;
	}
}

class Main {
	static List<ConferenceTime> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list.add(new ConferenceTime(start, end));
		}

		Collections.sort(list);
		int cnt = 0;
		int endTime = 0;

		for (ConferenceTime tmp : list) {
			if (tmp.start >= endTime) {
				cnt++;
				endTime = tmp.end;
			}
		}

		System.out.println(cnt);
	}

}