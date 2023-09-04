import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();
		Hanoi(N, 1, 2, 3);

		System.out.println(count);
		System.out.println(sb);

	}

	public static void Hanoi(int N, int A, int B, int C) {
		count++;
		if (N == 1) {
			sb.append(A + " " + C + "\n");
			return;
		}

		Hanoi(N - 1, A, C, B);
		sb.append(A + " " + C + "\n");
		Hanoi(N - 1, B, A, C);
	}

}
