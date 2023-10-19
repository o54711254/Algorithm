import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class island {
	char animal;
	int number;

	public island(char animal, int number) {
		super();
		this.animal = animal;
		this.number = number;

	}

}

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static island[] islands;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		islands = new island[N + 1];

		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		islands[1] = new island('S', 0);

		for (int i = 2; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			char ani = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			int con = Integer.parseInt(st.nextToken());

			graph.get(con).add(i);
			islands[i] = new island(ani, num);
		}

		System.out.println(dfs(1));

	}

	static long dfs(int index) {

		long result = 0; // 살아남은 양의 수

		for (int i = 0; i < graph.get(index).size(); i++) {
			result += dfs(graph.get(index).get(i));
		}

		if (islands[index].animal == 'S') {
			result += islands[index].number;
		} else {
			result -= islands[index].number;
		}

		if (result < 0) {
			result = 0;
		}
		return result;

	}
}