package stack_queue;

/*
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * */

public class StockPrice {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3}; // 주어진 테스트 케이스
		int[] answer = {};
		
		// 시작
		int[] cnts = new int[prices.length];
		for(int i=0; i<prices.length; i++) {
			int cnt=0;
			for(int j=i+1; j<prices.length; j++) {
				cnt ++; // 1초씩 지속
				if(prices[i] > prices[j]) // 가격이 떨어지면
					break; // 중단
			}
			cnts[i] = cnt;
		}
		
		answer = cnts;
		// 끝
		
		// 출력 확인
		for(int k=0; k<prices.length; k++) { // 4, 3, 1, 1, 0 이 나와야 함
			System.out.println(answer[k]);
		}
	}
}
