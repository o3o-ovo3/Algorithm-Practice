// 프로그래머스 Level2 - 다음 큰 숫자
// 정확성 테스트 성공, 효율성 테스트 실패 코드

class Solution {
    public int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n); // n의 이진표현
        nBinary = nBinary.replaceAll("0", ""); // 0 제거 --> 0을 제거하고 length()가 같으면 1의 개수가 같은거

        while(true){
            String newBinary = Integer.toBinaryString(++n).replaceAll("0", "");
            if(newBinary.length() == nBinary.length()){
                answer = n;
                break;
            }
        }
        return answer;
    }
}
