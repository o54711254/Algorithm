
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            BigInteger n = factorial(N);
            BigInteger r = factorial(R);
            BigInteger nCr = n.divide(r.multiply(factorial(N - R)));

            System.out.println(nCr);
        }
    }

    public static BigInteger factorial(int N) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
