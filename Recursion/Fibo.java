// 백준 알고리즘 재귀 - 피보나치 수 5

package baekjoon.recursion;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }
}
