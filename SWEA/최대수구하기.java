package SWEA;

import java.util.Scanner;

public class 최대수구하기 {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int times = sc.nextInt();
 
        int[] arr = new int[10];
         
        for(int a = 0; a<times; a++) {
             
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                for(int j =0; j<arr.length-1; j++) {
                    for(int k = 1; k < arr.length-j; k++) {
                        if(arr[k-1]<arr[k]) {
                            int tmp = arr[k-1];
                            arr[k-1] = arr[k];
                            arr[k] = tmp;
                        }
                    }
                }
            }
            System.out.println("#"+(a+1)+" "+arr[0]);
        }
    }
}