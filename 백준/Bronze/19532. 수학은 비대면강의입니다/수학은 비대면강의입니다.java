import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		for (int i = -999; i <= 999; i++) {
			for (int j = -999; j <= 999; j++) {
				if (i == (c*e-b*f)/(a*e-b*d) && j == (c*d-a*f)/(b*d-a*e)) {
					System.out.println(i + " " +j);
				}
			}
		}
	}
}
