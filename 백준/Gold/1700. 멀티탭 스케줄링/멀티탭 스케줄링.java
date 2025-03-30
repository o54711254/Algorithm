import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Set<Integer> multitab = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		List<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
			queue.add(num);
		}

		int count = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			list.remove(0);

			// 이미 꽂혀있다면 그냥 넘어감
			if (multitab.contains(now)) {
				continue;
			}
			// 만약 멀티탭 사이즈가 남으면 꽂기
			if (multitab.size() < N) {
				multitab.add(now);
				continue;
			}

			// 멀티탭에 꽂혀있는것 중에 앞으로 안쓸거 체크
			boolean use = true;
//			for (int i = 0; i < list.size(); i++) {
//				if()
//			}

			// 모두다 쓰면 가장 앞에서부터 나중에 등장하는거 지우기
			if (use) {
				int target = 0;
				Set<Integer> tempSet = new HashSet<>();
				for (int i = 0; i < list.size(); i++) {
					if (multitab.contains(list.get(i))) {
						tempSet.add(list.get(i));
						if (tempSet.size() == N) {
							target = list.get(i);
							break;
						}
					}
				}
				multitab.remove(target);
				multitab.add(now);
				count++;
			}
		}
		System.out.println(count);
	}

}