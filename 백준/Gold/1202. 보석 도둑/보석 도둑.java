import java.io.*;
import java.util.*;

class Jewel {
	int m;
	int v;

	public Jewel(int m, int v) {
		this.m = m;
		this.v = v;
	}

	@Override
	public String toString() {
		return "m : " + m + " v : " + v;
	}
}

public class Main {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Jewel[] arr = new Jewel[N];
		int[] bag = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[i] = new Jewel(m, v);
		}
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return o1.m - o2.m;
			}
		});
		Arrays.sort(bag);

		PriorityQueue<Jewel> pq = new PriorityQueue<Jewel>(new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return o2.v - o1.v;
			}
		});

		int index = 0;
		long result = 0;

		for (int i = 0; i < K; i++) {
			int weight = bag[i];

			while (index < N && arr[index].m <= weight) {
                pq.add(arr[index]);
                index++;
            }
			
			if (!pq.isEmpty()) {
				result += pq.poll().v;
			}
		}

		System.out.println(result);
	}
}