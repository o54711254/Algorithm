import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int countBlue, countWhite;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		White(N, 0, 0);
		
		System.out.println(countWhite);
		Blue(N, 0, 0);

		System.out.println(countBlue);

	}

	public static void Blue(int size, int x, int y) {
		if (size < 1) {
			return;
		}
		int sum = 0;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				sum += arr[i][j];
			}
		}
		int width = size * size;

		if (sum == width) {
			countBlue++;
			return;
		}
		int divide = size / 2;
		Blue(divide, x, y);
		Blue(divide, x, y + divide);
		Blue(divide, x + divide, y);
		Blue(divide, x + divide, y + divide);
	}

	public static void White(int size, int x, int y) {
		if (size < 1) {
			return;
		}
		int sum = 0;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				sum += arr[i][j];
			}
		}
		int width = size * size;

		if (sum == 0) {
			countWhite++;
			return;
		}
		int divide = size / 2;
		White(divide, x, y);
		White(divide, x, y + divide);
		White(divide, x + divide, y);
		White(divide, x + divide, y + divide);
	}
}
