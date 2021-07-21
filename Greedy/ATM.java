// 백준 알고리즘 그리디 - 

package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 몇명이 줄을 서있는지

        // 얼마 안걸리는 순서대로 돈을 인출하면 최소 시간
        // 걸리는 시간을 정렬, 지금까지 걸린 누적 시간 + 현재 고객이 걸리는 시간으로 계산
        List<Integer> list = new ArrayList<>(); // 걸리는 시간을 담은 리스트
        for(int i = 0; i < N; i++)
            list.add(sc.nextInt());

        Collections.sort(list);
        int sum = 0;
        int time = 0; // 누적 시간
        while(!list.isEmpty()){
            sum = sum + list.remove(0); // 현재 고객이 걸린 시간 (기다린 + 본인의 소요시간)
            time += sum; // 누적 시간에 더함
        }
        System.out.println(time);
    }
}
