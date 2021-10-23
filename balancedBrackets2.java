import java.util.*;

class balancedBrackets {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                boolean val = handleClosing(st, '(');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else if (ch == '}') {
                boolean val = handleClosing(st, '{');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else if (ch == ']') {
                boolean val = handleClosing(st, '[');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            }
        }
        // opening bracket jyada honge
        if (st.size() > 0) {
            System.out.println(false);
        } else {// pura bracket over sab khatam
            System.out.println(true);
        }

        scn.close();
    }

    public static boolean handleClosing(Stack<Character> st, char ch) {
        if (st.size() == 0) {// closing bracket jyada hue to
            return false;
        } else if (st.peek() != ch) {// opening aur closing bracket mismatch
            return false;
        } else {// misatch nahi hai nikalo brackets ko
            st.pop();
            return true;
        }
    }
}
