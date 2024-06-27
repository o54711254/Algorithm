import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int low = 0;
        int high = tree[N - 1];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;  // Use long to prevent overflow

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }

            if (sum >= M) {
                result = mid;  // update result
                low = mid + 1; // try for a higher value
            } else {
                high = mid - 1; // try for a lower value
            }
        }

        System.out.println(result);
    }
}