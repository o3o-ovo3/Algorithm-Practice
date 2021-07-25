// 백준 알고리즘 재귀 - 팩토리얼

package baekjoon.recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fac(n));
    }

    public static int fac(int n){
        if(n > 0){
            return n * fac(n-1);
        }
        return 1;
    }
}
