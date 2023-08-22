
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int[] light = new int[size];
		for (int i = 0; i < size; i++) {
			int n = sc.nextInt();
			light[i] = n;
		}

		int times = sc.nextInt();
		for (int i = 0; i < times; i++) {
			int gen = sc.nextInt();
			int num = sc.nextInt();

			if (gen == 1) {
				for (int j = 1; j <= size; j++) {
					if (j % num == 0) {
						light[j - 1] = 1 - light[j - 1];
					}
				}
			} else if (gen == 2) {
				int left = num - 2;
				int right = num;
				while (left >= 0 && right < size && light[left] == light[right]) {
					light[left] = 1 - light[left];
					light[right] = 1 - light[right];
					left--;
					right++;
				}
				light[num - 1] = 1 - light[num - 1];
			}
		}
		for(int i = 0; i<size; i++) {
			System.out.print(light[i]);
			System.out.print(" ");
			if((i+1)%20==0) {
				System.out.println();
			}
		}
	}

}
