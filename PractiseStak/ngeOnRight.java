import java.util.*;

class ngeOnRight {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] ans = solve(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        scn.close();
    }

    public static int[] solve(int[] arr, int n) {
        int[] ngeOnRight = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(n - 1);
        ngeOnRight[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                ngeOnRight[i] = -1;
            } else {
                ngeOnRight[i] = arr[st.peek()];
            }
            st.push(i);
        }
        return ngeOnRight;
    }
}