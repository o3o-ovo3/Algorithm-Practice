class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        int i = 0;
        int min = 0;
        int temp = 0;
        int index = 0;

        int n = 0;
        int com_val = 0; // 기준 값
        int result = 0; // 기준 값과 같거나 큰 경우

        // 정렬하기
        for (i = 0; i < citations.length - 1; i++) {
            min = citations[i];

            if (i != citations.length - 1) {
                for (int j = i + 1; j < citations.length; j++) {
                    if (min > citations[j]) {
                        min = citations[j];
                        index = j;
                    }
                }
                if (min != citations[i]) {
                    temp = citations[i];
                    citations[i] = min;
                    citations[index] = temp;
                }
            }
        }

        // 중간 값 찾기
        n = citations.length / 2;
        com_val = citations[n];

        // 중간 값과 인용 횟수 비교
        while (com_val > 0) {
            result = 0;
            for (i = 0; i < citations.length; i++) {
                if (com_val <= citations[i])
                    result++;
            }

            if (com_val <= result)
                break;
            else
                com_val--;
        }
        answer = com_val;
        return answer;
    }
}
