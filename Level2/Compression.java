// 프로그래머스 Level2 - 문자열 압축
// 실패
package programmers.level2;

public class Compression {
    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        int answer = 0;

        String str = ""; // 압축한 문자열
        int cnt = 1;
        int idx = 0;

        int size = 0;
        char c = 0;
        String temp = "";

        while (idx < s.length()) {
            if (temp.equals("")) {
                c = s.charAt(idx);
                temp += s.charAt(idx);
                idx++;
            } else if (s.charAt(idx) != c) {
                temp += s.charAt(idx);
                idx++;
            } else { // 첫 글자랑 같으면 반복
                if (temp.equals(s.substring(idx, idx + temp.length()))) {
                    cnt++;
                    idx = idx + temp.length();
                    if (c != s.charAt(idx)) {
                        if (cnt % 2 == 0) {
                            size = temp.length() * (cnt / 2);
                            for(int i = 0; i < cnt / 2 - 1; i++){
                                temp += temp;
                            }
                            temp = '2' + temp;
                        } else {
                            size = temp.length();
                            temp = Integer.toString(cnt) + temp;
                        }
                        str += temp;
                        temp = "";
                        cnt = 1;
                        break;
                    }
                }
            }
        }

        int start = 0;
        while(start < s.length()){
            if (temp.equals("")){
                temp = s.substring(start, size);
                start = size;
                size = size + size;
            }
            else{
                if(temp.equals(s.substring(start, size))){
                    cnt ++;
                    start = size;
                    size = size+size;
                }
                else{
                    str += Integer.toString(cnt) + temp;
                    temp = "";
                    cnt = 1;
                }
            }
        }
    }
}

