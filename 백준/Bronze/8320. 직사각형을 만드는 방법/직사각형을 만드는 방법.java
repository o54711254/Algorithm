import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		int i =0;
		while(true) {
			if(N/(i+1)-i<=0) {
				break;
			}
			sum += N/(i+1)-i;
			i++;
		}
		System.out.println(sum);
	}
}