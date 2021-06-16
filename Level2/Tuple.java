import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        List<String> group = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(s, "}");
        // 1. 각 집합을 떼어서 group에 저장
        while (true) {
            String str = st.nextToken();
            str = str.replaceAll("[{ ]", "");
            if(str.charAt(0) == ',')
                str = str.substring(1);
            group.add(str);
            if (!st.hasMoreTokens())
                break;
        }
        // 2. 그룹의 크기를 key로 하여 HashMap에 저장
        // 크기에 따라 정렬하기 위함
        // 원소가 제일 적은 것 부터 돌면서 배열에 넣어야하기 때문
        // --> {2} {1,2} {2,1,3} 은 튜플이 [2,1,3] 인데 [1,2,3]으로 나오면 안되니까
        // sort를 쓰면 {1,2} {2} {2,1,3} 이렇게 정렬됨
        HashMap<Integer, String> hm = new HashMap<>();
        for(String str : group){
            hm.put(str.length(), str);
        }

        int cnt = 0;
        // 사이즈가 제일 작은 문자열부터 탐색
        // 문자열의 ,를 기준으로 나눠서 숫자를 배열에 담음
        // 이미 배열에 숫자가 담겨 있는 경우 중복 저장하지 않음
        while(true){
            cnt ++;
            if(hm.get(cnt) == null)
                continue;
            else{
                String str = hm.remove(cnt);
                StringTokenizer st2 = new StringTokenizer(str, ",");
                while(true){
                    int val = Integer.parseInt(st2.nextToken());
                    if(!answer.contains(val)) // 중복 제거를 위한 코드
                        answer.add(val);
                    if(!st2.hasMoreTokens())
                        break;
                }
            }
            if(hm.isEmpty())
                break;
        }
        return answer;
    }
}
