import java.util.*;

class minStack2 {
    public static class MinStack2 {
        Stack<Integer> data;
        int min;

        public MinStack2() {
            data = new Stack<Integer>();
        }

        int size() {
            return data.size();
        }

        void push(int value) {
            if (data.size() == 0) {
                data.push(value);
                min = value;
            } else if (value >= min) {
                data.push(value);
            } else {
                data.push(value + value - min);// detection,storing a fake smaller value
                min = value;// original value stored in min
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("STACK UNDERFLOW");
                return -1;
            } else {
                if (data.peek() >= min) {
                    return data.pop();
                } else {
                    int ov = min;
                    min = 2 * min - data.pop();
                    return ov;
                }
            }
        }

        int top() {
            if (data.peek() >= min) {
                return data.peek();
            } else {
                return min;
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("STACK UNDERFLOW");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) {

    }
}
