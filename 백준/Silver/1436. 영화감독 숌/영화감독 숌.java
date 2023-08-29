import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int i = 0;
		int count = 0;
		while(true) {
			if(String.valueOf(i).contains("666")) {
				count++;
				if(count == N) {
					break;
				}
			}
			i++;
		}
		System.out.println(i);
	}
}
