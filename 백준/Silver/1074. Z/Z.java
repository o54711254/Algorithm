import java.io.*;
import java.util.*;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		find(size, r, c);
		System.out.println(cnt);
	}

	static void find(int size, int r, int c) {
		if (size == 1) {
			return;
		}
		int newSize = size / 2;

		// 1사분면
		if (r < newSize && c < newSize) {
			find(newSize, r, c);
		}

		// 2사분면
		else if (r < newSize && c >= newSize) {
			cnt += (size * size / 4);
			find(newSize, r, c - newSize);
		}

		// 3사분면
		else if (r >= newSize && c < newSize) {
			cnt += (size * size / 4) * 2;
			find(newSize, r - newSize, c);
		}

		// 4사분면
		else {
			cnt += (size * size / 4) * 3;
			find(newSize, r - newSize, c - newSize);
		}

	}
}