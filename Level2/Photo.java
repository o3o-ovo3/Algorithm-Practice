// 프로그래머스 레벨2 단체 사진 찍기
// 테스트 통과, 제출 실패
// 왜 실패했는지 모르겠음.. 

package programmers;

public class Photo {
    static int answer = 0;
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"}; // 입력
        //        int n = 2; String[] data = {"M~C<2", "C~M>1"}; // 입력

        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        char[] output = new char[friends.length];
        boolean[] visited = new boolean[friends.length]; // 방문 표시
//        int answer = 0;

        // 1. 줄을 서는 전체 경우의 수 찾기
        perm(friends, output, visited, 0, n, data);

        System.out.println(answer);
    }

    static void perm(char[] friends, char[] output, boolean[] visited, int depth,int n, String[] data){
        // 1. 줄을 서는 전체 경우의 수 찾기
        if(depth == friends.length){ // 2. 각 경우 마다 조건과 맞는지 검사해서 answer ++
            int right = 0;
            for(int i = 0; i < n; i++){
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
                        if(Math.abs(sub) -1 == dis)
                            right ++;
                        break;
                    case '>':
                        if(Math.abs(sub) -1 > dis)
                            right ++;
                        break;
                    case '<':
                        if(Math.abs(sub) -1 < dis)
                            right ++;
                        break;
                }
            }
            if(right == n) { // 모든 조건이 다 맞으면
                answer++; // answer ++
                System.out.println(answer);
            }
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
