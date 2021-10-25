import java.util.*;
import java.io.*;

class nextGreaterElementToRightv2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);

        display(nge);
    }

    public static int[] solve(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (st.size() > 0) {
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }
        return nge;
    }

    public static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }
}