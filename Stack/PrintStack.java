// 백준 알고리즘 스택

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            String s = token.nextToken();

            switch (s){
                case "push":
                    st.push(Integer.parseInt(token.nextToken()));
                    break;

                case "pop":
                    if(st.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(st.pop());
                    break;

                case "size":
                    System.out.println(st.size());
                    break;

                case "top":
                    if(st.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(st.peek());
                    break;

                case "empty":
                    if(st.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
            }
        }
    }
}
