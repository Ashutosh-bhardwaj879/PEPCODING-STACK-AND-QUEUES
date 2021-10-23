import java.util.*;

class main1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        try {
            String str = scn.nextLine();
            Stack<Character> st = new Stack<Character>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ')') {
                    if (st.peek() == '(') {
                        System.out.println(true);
                        return;
                    } else {
                        while (st.peek() != '(') {
                            st.pop();
                        }
                        st.pop();
                    }
                } else {
                    st.push(ch);
                }
            }
            System.out.println(false);
        } finally {
            scn.close();
        }
    }
}