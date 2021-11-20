import java.util.*;

class StackToQueueAddEff {
    public static class StackToQueue {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueue() {
            mainS = new Stack<Integer>();
            helperS = new Stack<Integer>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int peek() {
            if (size() == 0) {
                System.out.println("QUEUE UNDERFLOW");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.push(mainS.pop());
                }
                int val = mainS.pop();
                helperS.push(val);

                while (helperS.size() > 0) {
                    mainS.push(helperS.pop());
                }
                return val;
            }
        }

        int remove() {
            if (size() == 0) {
                System.out.println("QUEUE UNDERFLOW");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.push(mainS.pop());
                }
                int val = mainS.pop();

                while (helperS.size() > 0) {
                    mainS.push(helperS.pop());
                }
                return val;
            }
        }
    }

    public static void main(String[] args) {

    }
}
