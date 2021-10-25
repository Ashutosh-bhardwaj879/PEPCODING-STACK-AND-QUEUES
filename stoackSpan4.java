import java.io.*;
import java.util.*;

class stockSpan4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] stockSpan = solve(arr);
        display(stockSpan);
    }

    public static int[] solve(int[] arr) {
        int n = arr.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        return span;
    }

    public static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int val : arr) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }
}
