class Solution {
    public int[] solution(String s) {
        int[] answer;

        int count = 0;
        int round = 0;
        while (!s.equals("1")) {
            while (s.contains("0")) {
                s = s.replaceFirst("0", "");
                count++;
            }

            int c = s.length();
            s = Integer.toBinaryString(c);
            round++;
        }
        answer = new int[]{round, count};

        return answer;
    }
}
