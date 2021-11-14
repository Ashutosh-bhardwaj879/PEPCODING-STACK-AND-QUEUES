import java.util.*;
import java.io.*;

class infixConversion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> postfix = new Stack<String>();
        Stack<String> prefix = new Stack<String>();
        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch == 'a' && ch == 'z') || (ch == 'A' && ch == 'Z')) {
                postfix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    processing(postfix, prefix, operators);
                }
                operators.pop();// popping the '('
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {

                    processing(postfix, prefix, operators);

                }
                operators.push(ch);// pushing current operator
            }
        }
        while (operators.size() > 0) {
            processing(postfix, prefix, operators);
        }
        System.out.println("POSTFIX : " + postfix.pop());
        System.out.println("PREFIX  : " + prefix.pop());
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static void processing(Stack<String> postfix, Stack<String> prefix, Stack<Character> operators) {
        char op = operators.pop();

        String postv2 = postfix.pop();
        String postv1 = postfix.pop();
        String postv = postv1 + postv2 + op;
        postfix.push(postv);

        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        String prev = op + prev1 + prev2;
        prefix.push(prev);
    }
}
