import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int d = 0;
		
		if(a==b && b==c) {
			d += 10000 + 1000*a;
		}else if(a==b || b==c) {
			d += 1000 + 100*b;
		}else if(a==c) {
			d += 1000 + 100*a;
		}else {
			if(a>b && a>c) {
				d += a*100;
			}else if(b>c && b>a) {
				d += b*100;
			}else if(c>a&&c>b) {
				d += c*100;
			}
		}
		System.out.println(d);
	}
}
