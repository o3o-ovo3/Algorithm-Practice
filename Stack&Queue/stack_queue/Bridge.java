import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<Truck>();
        int nextTruckIndex = 1;
        int time = 1;
        
        int truckSum = truck_weights[0];
		bridge.add(new Truck(truck_weights[0], 0));
        
        while(true) {
			// 종료 조건
			if(bridge.size() == 0) {
				break;
			}
			
			time ++;
			for(int i = 0; i < bridge.size(); i++) {
				Truck truck = bridge.poll();
				truck.position++;
				
				if(truck.position == bridge_length) {
					truckSum -= truck.weight;
					i--;
				} else {
					bridge.add(truck);
				}
			}
			
			if(nextTruckIndex < truck_weights.length && truckSum + truck_weights[nextTruckIndex] <= weight) {
				truckSum += truck_weights[nextTruckIndex];
				bridge.add(new Truck(truck_weights[nextTruckIndex], 0));
				nextTruckIndex ++;
			}
		}
        
        return time;
    }
    
    
    class Truck{
        int weight;
        int position;
        
        public Truck(int weight, int position){
            this.weight = weight;
            this.position = position;
        }
    }
}