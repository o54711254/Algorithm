
class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {

		int cnt = 0;
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				cnt++;
			}

			for (int j = 0; j < 6; j++) {
				if (lottos[i] == win_nums[j]) {
					result++;
				}
			}
		}

		int[] answer = new int[2];

		int max = 7 - (result + cnt);
		if (max > 5) {
			max = 6;
		}
		
		int min = 7 - result;
		if (min > 5) {
			min = 6;
		}
		answer[0] = max;
		answer[1] = min;

		return answer;
	}
}