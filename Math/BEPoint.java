// 백준 알고리즘 수학 문제 1 - 손익분기점
// 반복문으로 최소 판매 대수를 찾으면 최악의 경우 21억 이상까지 반복 --> 시간 초과

package baekjoon.math;

import java.util.Scanner;

public class BEPoint {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 고정 지출
        int B = sc.nextInt(); // 생산비 (1대당)
        int C = sc.nextInt(); // 판매가격

        // n대를 판매한다고 할 때
        // Cn - (A + Bn) > 0 인 n을 찾는 문제
            // ㄴ Cn - A - Bn > 0
            // ㄴ n(C - B) > A
            // ㄴ n > A / (C - B)
        
        // 적자인지 아닌지 먼저 판단
        // A는 고정, B가 C보다 크거나 같으면 무조건 적자
        if(B >= C)
            System.out.println(-1);
        else {
            int n = A / (C - B) + 1; // n = A / (C - B) 이면 이 n은 수입과 지출이 같아지는 경우이기 때문에 +1을 더해야 최소 이익
            System.out.println(n);
        }
    }
}

