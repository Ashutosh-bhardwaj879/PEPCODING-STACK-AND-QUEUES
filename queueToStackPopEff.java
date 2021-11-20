import java.util.*;

class queueToStackPopEff {
    public static class QueueToStackPop {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackPop() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return mainQ.remove();
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack Undeflow");
                return -1;
            } else {
                return mainQ.peek();
            }
        }

        void push(int value) {
            while (mainQ.size() > 0) {
                helperQ.add(mainQ.remove());
            }
            mainQ.add(value);

            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
        }
    }

    public static void main(String[] args) {

    }
}
