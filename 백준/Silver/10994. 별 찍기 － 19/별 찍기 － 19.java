
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int size = (4 * N - 3);

		arr = new char[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = ' ';
			}
		}

		star(size, 0, 0);

		sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void star(int size, int x, int y) {
		if (size == 1) {
			arr[x][y] = '*';
			return;
		}

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i == x || j == y || j == x + size - 1 || i == y + size - 1) {
					arr[i][j] = '*';
				}
			}
		}
		star((size - 4), x + 2, y + 2);
	}
}