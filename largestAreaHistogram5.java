import java.util.*;

class largestAreaHistogram5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // code
        int[] rb = new int[n];
        rb[n - 1] = n;
        Stack<Integer> st = new Stack<Integer>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = n;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[] lb = new int[n];
        lb[0] = -1;
        Stack<Integer> stk = new Stack<>();
        stk.push(0);

        for (int i = 1; i < n; i++) {
            while (stk.size() > 0 && arr[i] < arr[stk.peek()]) {
                stk.pop();
            }

            if (stk.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = stk.peek();
            }
            stk.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);

        scn.close();
    }
}
