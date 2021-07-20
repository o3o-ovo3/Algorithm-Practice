package stack_queue;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> solution(int[] progresses, int[] speeds) {
		int[] period = new int[progresses.length];
		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			if ((100 - progresses[i]) % speeds[i] > 0)
				period[i] = (100 - progresses[i]) / speeds[i] + 1;
			else
				period[i] = (100 - progresses[i]) / speeds[i];
		}

		int work = 0;
		int max = period[0];
		for (int j = 1; j <= progresses.length; j++) {
			work++;
			if (j == progresses.length) {
				answer.add(work);
				break;
			}

			if (max < period[j]) {
				answer.add(work);
				max = period[j];
				work = 0;
			}
		}
		return answer;
	}
}
