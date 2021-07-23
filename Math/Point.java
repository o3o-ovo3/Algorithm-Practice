package baekjoon.math;

import java.util.Scanner;

public class BEPoint {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 고정 지출
        int B = sc.nextInt(); // 생산비 (1대당)
        int C = sc.nextInt(); // 판매가격

        int i  = 0;
        while(true){
            i++;
                    // 1 70  1000
            int out = i * B + A;
            System.out.println("out = " + out);

            int in = C * i - out;
            System.out.println("in = " + in);
            if(in > 0)
                break;
        }

        System.out.println(i);
    }
}
