
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int queue = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) deque.add(queue); 
        }

        sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int[] insert = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            insert[i] = Integer.parseInt(st.nextToken());


            int result = insert[i];
            deque.addFirst(result);
            result = deque.pollLast();
            sb.append(result + " ");

        }
        System.out.println(sb);
    }
}