// 프로그래머스 Level2 - 문자열 압축

class Solution {
    public int solution(String s) {
        int min = s.length();
        // 압축한 길이를 retrun하여 Math.min으로 비교

        // 압축 단위
        for(int i = 1; i <= s.length() / 2; i++){
            int compLeng = compression(s, i).length();
            min = Math.min(min, compLeng);
        }
        return min;
    }
    
    public String compression(String str, int i){
        int count = 1;
        String compression = ""; // 압축한 결과 문자열
        String pattern = ""; // 전 문자열

        for(int j = 0; j <= str.length() + i; j += i){
            String nowStr;

            // 전 문자열과 비교할 현재 문자열
            if(j >= str.length()) { // 현재 문자열이 없을 떄
                nowStr = "";
            } else if(str.length() < j + i){ // 마지막 현재 문자열일 때
                nowStr = str.substring(j); // 문자열의 끝까지 잘라오기
            } else{
                nowStr = str.substring(j, j+i); // 그 외의 경우
            }

            // 1. 전 문자열과 같은지 비교 (맨 처음일 경우 비교하지 않음)
            if(j != 0){
                if(nowStr.equals(pattern)) { // 똑같으면
                    count++;
                } else if (count >= 2) { // 다르고 count가 2회 이상이면 압축 가능
                    compression += count + pattern;
                    count = 1;
                } else {
                    // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
                    compression += pattern;
                }
            }
            // 2. i 길이만큼 문자열을 자른다.
            pattern = nowStr;
        }
        return compression;
    }
}
