import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
  
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
  
            int N = Integer.parseInt(br.readLine());
  
            int[] arr = new int[N];
  
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
  
            int[] arr2 = new int[N * (N - 1) / 2];
  
            int k = arr2.length - 1;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 1 + i; j < arr.length; j++) {
                    arr2[k--] = arr[i] * arr[j];
                }
            }
  
            int result = -1;
            for (int i = 0; i < arr2.length; i++) {
                boolean flag = true;
                int size = Integer.toString(arr2[i]).length();
                String item = Integer.toString(arr2[i]);
                for (int j = 1; j < size; j++) {
                    if (item.charAt(j - 1) > item.charAt(j)) {
                        flag = false;
                    }
                }
                if(flag) {
                    result = Math.max(result, arr2[i]);
                }
            }
            System.out.println("#"+tc+" "+result);
  
        }
    }
}