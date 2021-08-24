// 프로그래머스 DFS/BFS - 단어 변환

class Solution {
    static int answer = 0;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(words, begin, target, 0);
        return answer;
    }

    public void dfs(String[] words, String begin, String target, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i])
                continue;

            int k = 0; // 글자수 세기
            for(int j = 0; j < begin.length(); j++){
                if(words[i].charAt(j) == begin.charAt(j)){
                    k++;
                }
            }

            if(k == begin.length() - 1){
                visited[i] = true;
                dfs(words, words[i], target, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
