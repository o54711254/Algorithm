
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		char[] arr = new char[N];

		String str = br.readLine();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		
		int countS = 0;
		int countL = 0;
		for(int i =0; i<arr.length; i++) {
			if(arr[i] == 'S') {
				countS++;
			}else {
				countL++;
			}
		}
		
		int sum = (countS + countL/2)+1;
		
		if(N>sum) {
			System.out.println(sum);
		}else {
			System.out.println(N);
		}
		
	}
}