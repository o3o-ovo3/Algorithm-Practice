// 백준 알고리즘 브르투포스 - 분해합

package baekjoon.brute;

import java.util.Scanner;

public class Decom {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = N;
        int answer = N;

        int sum = 0;
        while(M > 0){
            String str = Integer.toString(M);
            sum = Integer.parseInt(str);
            for(int i = 0; i < str.length(); i++){
                sum+= Character.getNumericValue(str.charAt(i));
            }
            if(sum == N){
                answer = Math.min(M, answer);
            }
            M --;
        }
        if(answer == N)
            answer = 0;
        System.out.println(answer);
    }
}
