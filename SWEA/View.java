package SWEA;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        for (int case_time = 1; case_time <= 10; case_time++) {
 
            int size = sc.nextInt();
 
            int[] arr = new int[size];
 
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
 
            int sum = 0;
            int num = 0;
            for (int i = 2; i < (arr.length - 2); i++) {
                if (arr[i] > arr[i - 2] && arr[i] > arr[i - 1] && arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) {
                    int[] result = new int[5];
                    for (int j = 0; j < 5; j++) {
                        result[j] = arr[i - 2 + j];
                    }
 
                    for (int j = 0; j < 4; j++) {
                        for (int k = 1; k < 5 - j; k++) {
                            if (result[k - 1] < result[k]) {
                                int tmp = result[k - 1];
                                result[k - 1] = result[k];
                                result[k] = tmp;
                            }
                        }
                    }
                    sum += arr[i] - result[1];
                }
            }
            System.out.println("#" + case_time+" "+sum);
        }
    }
 
}