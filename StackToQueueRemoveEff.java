import java.util.*;

class StackToQueueRemoveEff {
    public static class StackToQueueRemEff {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueRemEff() {
            mainS = new Stack<Integer>();
            helperS = new Stack<Integer>();
        }

        void add(int value) {
            while (mainS.size() > 0) {
                helperS.push(mainS.pop());
            }

            mainS.push(value);

            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }

        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.pop();
            }
        }

        int size() {
            return mainS.size();
        }

        int top() {
            if (size() == 0) {
                System.out.println("QUEUE UNDERFLOW");
                return -1;
            } else {
                return mainS.peek();
            }
        }
        
    }
}
