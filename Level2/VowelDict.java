import java.util.*;

class Solution {
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static char[] p;
    static int N = alpha.length;
    static int R;
    
    public int solution(String word) {
        int answer = 0;

        // 한글자 단어부터 5글자 단어까지 모든 단어 탐색
        List<String> list = new ArrayList<>();

        // 사전 만들기
        for(int i = 1; i <= N; i++){
            R = i;
            p = new char[R];

            // R이 i가 되는거지
            combination(0, list);
        }

        Collections.sort(list); // 사전식으로 정렬

        answer = list.indexOf(word) + 1;

        return answer;
    }
    
    public void combination(int cnt, List<String> list){
        if(cnt == R){
            list.add(new String(p));
            return;
        }

        for(int j = 0; j < N; j++){
            p[cnt] = alpha[j];
            combination(cnt + 1, list);
        }
    }
}
