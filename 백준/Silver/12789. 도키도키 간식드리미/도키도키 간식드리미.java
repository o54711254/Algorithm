import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<Integer>();

        int cnt = 1;
        int i = 0;
        while (!stack.isEmpty() || i < N) {
            if (!stack.isEmpty() && stack.peek() == cnt) {
                stack.pop();
                cnt++;
            } else if (i < N) {
                stack.add(arr[i]);
                i++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
