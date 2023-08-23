
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();

		int count = 0;
		if (str.contains("c=")) {
			str=str.replace("c=", "A");
		}
		if (str.contains("c-")) {
			str=str.replace("c-", "A");
		}
		if (str.contains("dz=")) {
			str=str.replace("dz=", "A");
		} 
		if (str.contains("d-")) {
			str=str.replace("d-", "A");
		} 
		if (str.contains("lj")) {
			str=str.replace("lj", "A");
		} 
		if (str.contains("nj")) {
			str = str.replace("nj", "A");
		} 
		if (str.contains("s=")) {
			str = str.replace("s=", "A");
		} 
		if (str.contains("z=")) {
			str = str.replace("z=", "A");
		}
		
		System.out.println(str.length());
	}
}