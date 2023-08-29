
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		String str = br.readLine();

		char[] arr = str.toCharArray();

		Arrays.sort(arr);
		
		int size = arr.length;
		sb = new StringBuilder();
		for(int i = size-1; i>=0; i--) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}
}