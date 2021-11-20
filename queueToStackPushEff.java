import java.util.*;

class queueToStackPushEff {

    public static class QueueToStackPushEfficient {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackPushEfficient() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        void push(int value) {
            mainQ.add(value);
        }

        int size() {
            return mainQ.size();
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }
                int val = mainQ.remove();

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }

                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }
                int val = mainQ.remove();
                helperQ.add(val);

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }

                return val;
            }
        }
    }

    public static void main(String[] args) {

    }
}
