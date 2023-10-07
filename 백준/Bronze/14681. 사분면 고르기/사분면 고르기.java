import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		if (n > 0 && m > 0) {
			System.out.println(1);
		} else if (n > 0 && m < 0) {
			System.out.println(4);
		} else if (n < 0 && m > 0) {
			System.out.println(2);
		}else {
			System.out.println(3);
		}
	}
}