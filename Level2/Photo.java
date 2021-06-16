// 프로그래머스 레벨2 단체 사진 찍기

class Solution {
    static int answer = 0;
    public int solution(int n, String[] data) {
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        char[] output = new char[friends.length];
        boolean[] visited = new boolean[friends.length]; // 방문 표시
        
        answer = 0; // 전역 변수를 초기화 해주어야 함 --> 왜일까?..
        // 1. 줄을 서는 전체 경우의 수 찾기
        perm(friends, output, visited, 0, n, data);
        
        return answer;
    }
    static void perm(char[] friends, char[] output, boolean[] visited, int depth,int n, String[] data){
        // 1. 줄을 서는 전체 경우의 수 찾기
        if(depth == friends.length){ // 2. 각 경우 마다 조건과 맞는지 검사해서 answer ++
            boolean isTrue = true; // 조건 하나라도 부합을 안하면 바로 검사를 멈출 수 있도록 flag 변수
            for(int i = 0; i < n; i++){
                if(!isTrue)
                    break;
                char c1 = data[i].charAt(0);
                char c2 = data[i].charAt(2);
                int a = 0, b = 0;
                for(int j = 0; j < friends.length; j++){
                    if(output[j] == c1)
                        a = j;
                    if(output[j] == c2)
                        b = j;
                }

                int sub = a - b;
                char op = data[i].charAt(3);
                int dis = Integer.parseInt(data[i].charAt(4) + "");
                switch (op){
                    case '=':
                        // 인덱스의 차가 두 사람 사이의 간격 보다 1만큼 크기 때문에 -1 해주어야함
                        if(Math.abs(sub) -1 != dis)
                            isTrue = false;
                        break;
                    case '>':
                        if(Math.abs(sub) -1 <= dis)
                            isTrue = false;
                        break;
                    case '<':
                        if(Math.abs(sub) -1 >= dis)
                            isTrue = false;
                        break;
                }
            }
            if(isTrue)
                answer ++;
            return;
        }

        for(int i = 0; i < friends.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = friends[i];
                perm(friends, output, visited, depth + 1,n, data);
                visited[i] = false;
            }
        }
    }
}
