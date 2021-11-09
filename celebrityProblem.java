import java.util.*;

class celebrityProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        findCelebrity(arr, n);
        scn.close();
    }

    // if a celebrity is there print the index otherwise print none
    public static void findCelebrity(int[][] arr, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                // if i knows j then i is not a celebrity
                st.push(j);
            } else {
                // if i doesnt knows j then j is not a celebrity
                st.push(i);
            }
        }

        int pot = st.pop();

        for (int i = 0; i < n; i++) {
            if (pot != i) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
}
