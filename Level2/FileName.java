// 프로그래머스 레벨2 - 파일명 정렬

import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        // Comparator를 이용하여 구분 (오버라이드하여 재정의)
        // 1. head만 비교하여 정렬한다.
        // 2. head가 같을 경우 (comparator 결과 0이 나올 경우) --> 숫자끼리 비교한다.

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1을 수행하기 위해 head 추출 --> split을 이용 --> split을 하면 배열이 제공됨, 처음 숫자가 나오기 첫번째만 head이므로 [0]을 참조
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                // CompareTo를 사용하여 비교 --> 대소문자를 구분하지 않음
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());

                if(result == 0) { // 2의 경우에 해당하면
                    result = compNum(o1, head1) - compNum(o2, head2);
                }

                return result;
            }
        });
        return files;
    }
    
    public static int compNum(String fileName, String head){
        fileName = fileName.substring(head.length()); // 헤드 이후부터 시작
        String result = "";
        // 숫자 추출 --> 숫자는 5개까지만
      
      // --------------------- 통과 코드
        for(char c : fileName.toCharArray()){
            if(Character.isDigit(c) && result.length() < 5)
                result+= c;
            else
                break;
        }
      // ---------------------
      
      
      /* 시간 초과 코드
      for(int i = 0; i < 5; i++){
            char c = fileName.charAt(i); // 한 문자씩 가져오기
            if(Character.isDigit(c)) // isDigit --> 숫자인지 판별
                result += c;// 숫자면 result에 붙이기
            else break; // 숫자가 아니면 끝
        }
      */
        return Integer.parseInt(result); // 숫자 형태로 비교할 수 있도록
    }
}
