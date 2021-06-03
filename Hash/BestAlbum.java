import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        int size = genres.length;
        HashMap<String, Integer> hm = new HashMap<>();
        // 장르별 총 재생 횟수 구하기
        for (int i = 0; i < size; i++) {
            if (hm.get(genres[i]) == null)
                hm.put(genres[i], plays[i]);
            else {
                int total = hm.get(genres[i]);
                hm.put(genres[i], total + plays[i]);
            }
        }

        // 재생 횟수 많은 장르 순으로 정렬
        List<String> keySetList = new ArrayList<>(hm.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // get매소드를 통해 value 끼리 비교
                return hm.get(o2).compareTo(hm.get(o1));
            }
        });

        for (int j = 0; j < keySetList.size(); j++) {
            Song first = new Song(0, 0);
            Song second = new Song(0, 0);

            // genres 배열에서 각 장르 마다 골라내기
            for (int k = 0; k < size; k++) {
                if (keySetList.get(j).equals(genres[k])) { // String 비교는 equals!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    if (first.plays == 0) {
                        first = new Song(k, plays[k]);
                    } else {
                        if (first.plays < plays[k]){
                            second = first;
                            first = new Song(k, plays[k]);
                        }
                        else if (plays[k] > second.plays) {
                            second = new Song(k, plays[k]);
                        }
                    }
                }
            }
            answer.add(first.num);
            if (second.plays != 0)
                answer.add(second.num);
        }
        return answer;
    }
    class Song{
        int num;
        int plays;

        public Song(int num, int plays){
            this.num = num;
            this.plays = plays;
        }
    }
}
