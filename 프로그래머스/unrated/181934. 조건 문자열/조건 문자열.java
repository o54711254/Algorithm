class Solution {
    public int solution(String ineq, String eq, int n, int m) {
if (ineq.equals(">")) {
			if (eq.equals("=")) {
				int answer = n >= m ? 1 : 0;
				return answer;
			} else {
				int answer = n > m ? 1 : 0;
				return answer;
			}
		} else {
			if (eq.equals("=")) {
				int answer = n <= m ? 1 : 0;
				return answer;
			} else {
				int answer = n < m ? 1 : 0;
				return answer;
			}
		}
	}
}