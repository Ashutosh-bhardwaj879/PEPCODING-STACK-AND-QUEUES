import java.io.*;
import java.util.*;

class nextGreaterElementToRight {
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

        Stack<Integer> st = new Stack<Integer>();

        st.push(arr[n - 1]);

        nge[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {

            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(arr[i]);
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
