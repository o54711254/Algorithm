import java.util.Scanner;
 
public class 중간값찾기 {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
 
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
 
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1+i; j < N; j++) {
                if(arr[i]>arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(arr[(arr.length-1)/2]);
    }
 
}