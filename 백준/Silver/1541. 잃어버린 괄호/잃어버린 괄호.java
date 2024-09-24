import java.io.*;
import java.util.*;
import java.awt.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();
		
		int sum = Integer.MAX_VALUE;

		String[] strMinus = str.split("-");

		for (String m : strMinus) {
			int temp = 0;

			String[] strPlus = m.split("\\+");

			for (String p : strPlus) {
				temp += Integer.parseInt(p);
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}else {
				sum -= temp;
			}
			
		}
		System.out.println(sum);

	}

}