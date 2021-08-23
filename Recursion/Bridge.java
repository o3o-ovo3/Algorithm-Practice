// 구름LEVEL - 다리 건너기
// 테스트 케이스 통과, 제출 실패 코드

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int cnt = 0;
        List<Integer> helper = new ArrayList<>();
        cnt = escape(list, helper, cnt);

        System.out.println(cnt);
	}

    public static int escape(List<Integer> waiting, List<Integer> helper, int cnt) {
        if(helper.isEmpty()) {
            if(waiting.size() <= 3){
                // 종료 조건 (가장 빠른 사람이 3명 이하 남았을 때)
                cnt += waiting.remove(waiting.size() - 1); // 가장 느린 애 속도 만큼 걸림
                if(waiting.size() == 1) { return cnt;}
                else {
                    cnt += waiting.get(0); // 가장 빠른애가 돌아옴
                    cnt += waiting.get(1); // 둘 중 느린 사람 속도 만큼 시간 걸림
                    return cnt;
                }
            }
            else {
                int h1 = waiting.remove(0);
                int h2 = waiting.remove(0);

                cnt += h2;

                helper.add(h1);
                helper.add(h2);
            }
        } else {
            // 가장 느린 두 사람을 보냄
            cnt += waiting.remove(waiting.size() - 1);
            waiting.remove(waiting.size() - 1);
        }

        int h = helper.remove(0);
        cnt+= h; // 빠른 애가 돌아옴
        waiting.add(h);

        Collections.sort(waiting);
        return escape(waiting, helper, cnt);
    }
}
