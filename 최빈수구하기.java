import java.util.Scanner;
 
public class 최빈수구하기 {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int test_case = sc.nextInt();
 
        for (int test = 1; test <= test_case; test++) {
            int n = sc.nextInt();
 
            int[] score = new int[1000];
            for (int i = 0; i < 1000; i++) {
                score[i] = sc.nextInt();
            }
 
            int max = -1;
            for (int i = 0; i < score.length; i++) {
                if (max < score[i]) {
                    max = score[i];
                }
            }
 
            int[] count = new int[max + 1];
 
            for (int i = 0; i < score.length; i++) {
                count[score[i]]++;
            }
 
            int k = 0;
            for (int i = 0; i < count.length; i++) {
                if (k <= count[i]) {
                    k = count[i];
                }
            }
 
            int cnt = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] == k) {
                    cnt++;
                }
            }
            int[] result = new int[cnt];
            for (int i = 0; i < count.length; i++) {
                if (count[i] == k) {
                    for (int j = 0; j < cnt; j++) {
                        result[j] = i;
                    }
                }
            }
 
            System.out.println("#"+n+" " +result[cnt - 1]);
        }
    }
}