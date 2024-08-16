import java.io.*;
import java.util.*;
import java.awt.*;

class Main {
	static int N;
	static int result;
	static ArrayList<Long> pointList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		pointList = new ArrayList<>();

		if (N < 10) {
			System.out.println(N);
			return;
		} else if (N >= 1023) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < 10; i++) {
			search(1, i);
		}

		Collections.sort(pointList);

		System.out.println(pointList.get(N));

	}

	static void search(int idx, long number) {
		if (idx > 10) {
			return;
		}
		pointList.add(number);
		for (int i = 0; i < number % 10; i++) {
			search(idx + 1, number * 10 + i);
		}
	}
}