import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";

        int idx = 0;
        int size = s.length();

        String temp = "";
        while (idx < size) {
            // 마지막 인덱스일 경우 temp를 answer에 추가
            if (s.charAt(idx) == ' ') {
                if (!temp.equals("")) {
                    answer += temp.substring(0, 1).toUpperCase();
                    answer += temp.substring(1);
                    temp = ""; // temp 초기화
                }
                answer += " ";
            } else {
                temp += Character.toString(s.charAt(idx)).toLowerCase();

                if(idx == size - 1 && !temp.equals("")){
                    answer += temp.substring(0, 1).toUpperCase();
                    answer += temp.substring(1);
                    break;
                }
            }
            idx++;
        }
        return answer;
    }
}
