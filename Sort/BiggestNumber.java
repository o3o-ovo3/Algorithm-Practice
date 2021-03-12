import java.util.*;

class Number implements Comparable<Number> {
    private String num;


    public Number(String num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(Number n1) {
        int result = 0;
        if(Integer.parseInt(this.num + n1.num) > Integer.parseInt(n1.num + this.num)) // 3, 30이 들어오면 330이랑 303이랑 비교하는거지
            result = -1;
        else if(Integer.parseInt(this.num + n1.num) < Integer.parseInt(n1.num + this.num))
            result = 1;
        else result = 1; // 중복이어도 넣어버려
        return result;
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Set<Number> treeSet = new TreeSet<Number>();

        for (int num : numbers) {
            String number = Integer.toString(num);
            treeSet.add(new Number(number));
        }

        Iterator<Number> itr = treeSet.iterator();

        while (itr.hasNext()) {
            answer += itr.next(); // 하나씩 꺼내서 붙이기 연산자로 String 변수에 저장
            if (answer.equals("0"))
                break; // 처음 꺼낸 숫자가 0이면 끝내기
        }
        
        return answer;
    }
}
