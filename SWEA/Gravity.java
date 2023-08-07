package SWEA;

import java.util.Scanner;

public class Gravity {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int times = sc.nextInt();
        for(int k = 0; k<times; k++) {
             
            int size = sc.nextInt();
             
             
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
             
            int[] result = new int[size]; 
            for(int i =0; i<size; i++) { 
                int max = size-(i+1);
                for (int j = 1; j <= (size-1); j++) {
                    if (arr[i] <= arr[j]) {
                        max--;
                        result[i] = max;
                    }
                }
            }
             
            int num =0;
            for(int i =0; i<result.length; i++) {
                if(num<result[i]) {
                    num = result[i];
                }
            }
            System.out.println("#"+(k+1)+" "+num);
        }
    }
}