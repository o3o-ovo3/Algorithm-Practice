// 프로그래머스 Level2 - 다음 큰 숫자
// replace 메소드보다 for문 돌리는게 더 효율성이 있나보다..

class Solution {
    public int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n); // n의 이진표현

        int cnt = 0;
        for (int i = 0; i < nBinary.length(); i++) {
            if (nBinary.charAt(i) == '1')
                cnt++;
        }

        while (true) {
            String newBinary = Integer.toBinaryString(++n);
            int newCnt = 0;
            for (int i = 0; i < newBinary.length(); i++) {
                if (cnt < newCnt)
                    break;
                if (newBinary.charAt(i) == '1')
                    newCnt++;
            }

            if (cnt == newCnt) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}
