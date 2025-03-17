import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int low = Integer.parseInt(st.nextToken());
		int high = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		int value = 0;
		while(value < low){
			value = num * cnt;
			cnt++;
		}
		System.out.println(value <= high ? "Y" : "N");
	}
}