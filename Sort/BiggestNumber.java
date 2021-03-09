// 실패한 코드

import java.util.*;

class Number implements Comparable<Number> {
    private int num;
    private int firstNum; // 수의 첫번째 숫자
    private int lastNum; // 수의 일의자리 숫자

    private int length; // 자릿 수

    public Number(int num) {
        this.num = num;
        this.lastNum = num % 10; // 일의 자리 수 구하기
        this.length = (int) (Math.log10(num) + 1); // 자릿 수 구하기
        if (length == 1) // 일의 자리 숫자일 경우
            firstNum = num; // 자기 자신
        else
            firstNum = (num / (int) (Math.pow(10, length - 1))); // 아닌 경우 자릿수 -1 만큼 10 제곱으로 나눠줌 (나눈 몫이 첫 숫자)
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(Number n) {
        int result = 1;

        // 첫번째 숫자로 1차 분류 (큰수를 앞으로)
        if (n.firstNum != this.firstNum) {
            result = n.firstNum - this.firstNum;
        } else {
            // 자릿 수가 같을 경우
            if (n.length == this.length) {
                if (n.num == this.num)
                    result = 1; // 중복이어도 그냥 넣어
                else
                    result = n.num - this.num; // 큰 수를 앞으로
            }

            // 자릿 수가 다를 경우
            else {
                int n_bareNum = n.num - (int) (Math.pow(10, n.length - 1)) * n.firstNum;
                int this_bareNum = this.num - (int) (Math.pow(10, this.length - 1)) * this.firstNum;
                // 둘 중 하나의 자릿 수가 1 --> 나머지 수의 두번째 숫자가 같거나 더 커야 앞으로
                if (n.length == 1) {
                   if(this_bareNum / (int)(Math.pow(10, this.length - 2)) <= n.num)
                        result = 1;
                   else result = -1;
                }

                else if (this.length == 1) {
                    if(n_bareNum / (int)(Math.pow(10, n.length - 2)) >= this.num)
                        result = 1;
                    else result = -1;
                }

                // 둘 중 하나의 자릿 수가 2, 다른 하나는 3
                else if (n.length == 2) {
                    // 두번째 숫자끼리 비교
                    // 두번째 숫자
                    int n_second = n_bareNum / (int)(Math.pow(10, n.length - 2));
                    int this_second = this_bareNum / (int)(Math.pow(10, this.length - 2));

                    if(n_second > this_second)
                        result = 1;
                    else if(n.firstNum > this.lastNum)
                        result = 1;
                    else result = -1;
                }

                else if (this.length == 2) {
                    System.out.println("2ㅇ");
                    int n_second = n_bareNum / (int)(Math.pow(10, n.length - 2));
                    int this_second = this_bareNum / (int)(Math.pow(10, this.length - 2));

                    if(this_second < n_second)
                        result = 1;
                    else if(this.firstNum <= n.lastNum)
                        result = 1;
                    else result = -1;
                }
                else result = -1;
            }
        }
        return result;
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Set<Number> treeSet = new TreeSet<Number>();

        for(int num : numbers){
            treeSet.add(new Number(num));
        }

        Iterator<Number> itr = treeSet.iterator();
        
        while(itr.hasNext()){
            answer += itr.next(); // 하나씩 꺼내서 붙이기 연산자로 String 변수에 저장
            if(answer.equals("0")) break; // 처음 꺼낸 숫자가 0이면 끝내기
        }
        
        return answer;
    }
}
