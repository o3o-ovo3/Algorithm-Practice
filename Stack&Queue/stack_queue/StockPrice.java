package stack_queue;

/*
 * �� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��, ������ �������� ���� �Ⱓ�� �� �������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * */

public class StockPrice {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3}; // �־��� �׽�Ʈ ���̽�
		int[] answer = {};
		
		// ����
		int[] cnts = new int[prices.length];
		for(int i=0; i<prices.length; i++) {
			int cnt=0;
			for(int j=i+1; j<prices.length; j++) {
				cnt ++; // 1�ʾ� ����
				if(prices[i] > prices[j]) // ������ ��������
					break; // �ߴ�
			}
			cnts[i] = cnt;
		}
		
		answer = cnts;
		// ��
		
		// ��� Ȯ��
		for(int k=0; k<prices.length; k++) { // 4, 3, 1, 1, 0 �� ���;� ��
			System.out.println(answer[k]);
		}
	}
}
