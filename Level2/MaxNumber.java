// 프로그래머스 Level2 - 큰 수 만들기 (그리디 문제)
// 테스트케이스 통과, 채점 실패 코드

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int size = number.length() - k; // 남겨야하는 숫자의 개수
        int cnt = 0; // 제거한 숫자 개수

        char[] toChar = number.toCharArray();
        int max = -1;
        int idx = 0;

        while(idx < k){
            if(Character.getNumericValue(toChar[idx]) == 9)
                break;
            if(Character.getNumericValue(toChar[idx]) > max && toChar.length - idx >= size) {
                max = Character.getNumericValue(toChar[idx]);
                cnt = idx; // idx 이전의 모든 숫자들을 제거
            }
            idx ++;
        }

        idx = cnt; // max 값 부터 조사

        while(idx < toChar.length){
            if(cnt >= k) { // 더 이상 제거할 수 없다면 모두 answer에 저장
                while(idx < toChar.length){
                    answer += Character.getNumericValue(toChar[idx]);
                    idx++;
                }
                break;
            }
            
            if(Character.getNumericValue(toChar[idx]) >= Character.getNumericValue(toChar[idx + 1]))
                answer += Character.getNumericValue(toChar[idx]);

            else cnt ++;

            idx++;
        }
        
        return answer;
    }
}
