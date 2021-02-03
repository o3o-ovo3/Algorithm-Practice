package stack_queue;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
	public static void main(String[] args) {
		// 주어진 데이터
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
/*
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		*/
		List<Integer> on_bridge = new ArrayList<Integer>();
		int answer;
		
		int sec = 0;
		int max = 0;
		
		for(int i = 0; i < truck_weights.length; i++) {

			sec ++;
			System.out.println(sec+"초");
			if(sec >= weight && sec % bridge_length == 0) {
				System.out.println(on_bridge.get(0) + "을 삭제");
				max -= on_bridge.get(0);
				on_bridge.remove(0);
				sec++;
				System.out.println("합계" + max);
			}
			System.out.println("현재 값 : " + truck_weights[i]);
			if(max == 0) {
				System.out.println("추가");
				max += truck_weights[i];
				System.out.println("max는 ! " + max);
				on_bridge.add(truck_weights[i]);
			} else if(max + truck_weights[i] <= 10) {
				System.out.println("추가");
				System.out.println("max값: " + max);
				max += truck_weights[i];
				on_bridge.add(truck_weights[i]);
			} 
			
			if(i == truck_weights.length - 1) {
				sec++;
			}
			for(int on : on_bridge) {
				System.out.println("잔여 : " + on);
			}
			System.out.println("-------");
			
		}
		

		System.out.println(sec);
	}
}
