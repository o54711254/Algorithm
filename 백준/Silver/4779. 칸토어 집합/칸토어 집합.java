import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		String str;
		while ((str = br.readLine()) != null) {

			int N = Integer.parseInt(str);
			int size = (int) Math.pow(3, N);

			arr = new char[size];

			for (int i = 0; i < size; i++) {
				arr[i] = '-';
			}

			func(0, size);

			sb = new StringBuilder();

			for (int i = 0; i < size; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		}
	}

	public static void func(int start, int size) {
		if (size == 1) {
			return;
		}
		int divide = size / 3;

		for (int i = start + divide; i < start + 2 * divide; i++) {
			arr[i] = ' ';
		}

		func(start, divide);
		func(start + 2 * divide, divide);
	}
}