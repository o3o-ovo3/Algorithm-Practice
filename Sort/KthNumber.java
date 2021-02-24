class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int size = 0;
        int k = 0; // k 번

        // commands 배열의 행 수 만큼 반복
        for (int i = 0; i < commands.length; i++) {
            // 자르기
            size = commands[i][1] - commands[i][0] + 1;
            k = commands[i][2] - 1;

            int[] new_arr = new int[size];
            int index = 0;

            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                new_arr[index] = array[j];
                index++;
            }

            int min = 0;
            int temp = 0;

            // 정렬하기
            for (int z = 0; z < new_arr.length - 1; z++) {
                min = new_arr[z];

                if (z != new_arr.length - 1) {
                    for (int x = z + 1; x < new_arr.length; x++) {
                        if (min > new_arr[x]) {
                            min = new_arr[x];
                            index = x;
                        }
                    }

                    if (min != new_arr[z]) {
                        temp = new_arr[z];
                        new_arr[z] = min;
                        new_arr[index] = temp;
                    }
                }
            }
            // k 번째 수 answer에 넣기
            answer[i] = new_arr[k];
        }
        return answer;
    }
}
