package SWEA;

import java.util.Scanner;

public class 중간평균값구하기 {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int case_times = 1; case_times <= times; case_times++) {
 
            int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
 
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < arr.length - i; j++) {
                    if (arr[j - 1] < arr[j]) {
                        int tmp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
            double sum = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                sum += arr[i];
            }
            System.out.println("#"+case_times+" "+Math.round((sum/(arr.length - 2))));
        }
    }
 
}
