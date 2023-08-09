import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int test_case = sc.nextInt();
 
        for (int cs = 1; cs <= test_case; cs++) {
 
            int N = sc.nextInt();
            int M = sc.nextInt();
 
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            int max = 0;
 
            for (int i = 0; i < (N - M) + 1; i++) {
                for (int j = 0; j < (N - M) + 1; j++) {
                    int sum = 0;
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            sum += arr[i + k][j + l];
                        }
                        if (max < sum) {
                            max = sum;
                        }
                    }
                }
            }
            System.out.println("#"+cs+" "+max);
        }
    }
}