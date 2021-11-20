import java.util.*;

class nseOnLeft {
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
        int[] nseOnLeft = new int[n];
        Stack<Integer> st = new Stack<>();
        nseOnLeft[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                nseOnLeft[i] = -1;
            } else {
                nseOnLeft[i] = arr[st.peek()];
            }
            st.push(i);
        }

        return nseOnLeft;
    }

}
