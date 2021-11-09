import java.io.*;
import java.util.*;

class slidingwindowMax {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        // next greater indexes on right
        // but slightly different from it in this we are storing Indexes not elements
        int[] ngiOnRight = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(arr.length - 1);// n-1
        ngiOnRight[arr.length - 1] = arr.length; // n-1 = n

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                ngiOnRight[i] = arr.length;
            } else {
                ngiOnRight[i] = st.peek();// we are string indexes not elements
            }
            st.push(i);
        }

        // coding for sliding loops

        for (int i = 0; i <= arr.length - k ; i++) {
            int j = i;
            while (ngiOnRight[j] < i + k) {
                j = ngiOnRight[j];
            }
            System.out.print(arr[j]+" ");
        }
        // for above loop slight modification
        /*
         * int j = 0; for (int i = 0; i < arr.length - k; i++) { if (i < j) { j = i; }
         * while (ngiOnRight[j] < i + k) { j = ngiOnRight[j]; }
         * System.out.println(arr[j]); }
         */
        scn.close();
    }
}