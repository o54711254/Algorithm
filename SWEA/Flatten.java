import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int size = 100;
		int test_case = 10;
		
		for(int test = 1; test <= test_case; test++) {
			
			
			int dump = sc.nextInt();
			int[] arr = new int[size];
			
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			int result = 0;
			for (int k = 0; k < dump; k++) {
				
				for (int i = 0; i < size - 1; i++) {
					for (int j = 1 + i; j < size; j++) {
						if (arr[i] < arr[j]) {
							int tmp = arr[i];
							arr[i] = arr[j];
							arr[j] = tmp;
						}
					}
				}
				
				arr[0]--;
				arr[arr.length - 1]++;
				for (int i = 0; i < size - 1; i++) {
					for (int j = 1 + i; j < size; j++) {
						if (arr[i] < arr[j]) {
							int tmp = arr[i];
							arr[i] = arr[j];
							arr[j] = tmp;
						}
					}
				}
				int max = arr[0];
				int min = arr[arr.length - 1];
				result = max - min;
			}
			System.out.println("#" + test+" "+result);
		}
		
	}

}
