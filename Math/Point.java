// 백준 알고리즘 수학 문제 1 - 손익분기점
// 시간 초과

package baekjoon.math;

import java.util.Scanner;

public class BEPoint {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 고정 지출
        int B = sc.nextInt(); // 생산비 (1대당)
        int C = sc.nextInt(); // 판매가격

        int temp = 0; // 수입이 이전 대비 상승했는지 알아보기 위한 변수
        int i  = 0; // 몇번째인지 카운트
        while(i <= 2100000000){ // 입력갑은 21억 이하
            i++;

            int out = i * B + A;

            int in = C * i - out;

            if(temp == 0)
                temp = in;

            else if(temp > in){ // 대수를 증가해도 수입이 상승하지 않았을 때
                i = -1;
                break;
            }

            if(in > 0) // 수입이 지출보다 클 때
                break;
        }

        System.out.println(i);
    }
}
