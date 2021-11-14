import java.io.*;
import java.util.*;

class buildNormalStack {

    public static class CustomStack {

        int[] data;
        int tos;// top of the stack

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (tos == data.length - 1) {
                System.out.println("STACK OVERFLOW");
            } else {
                tos++;
                data[tos] = val;
            }
        }

        int pop() {
            if (tos == -1) {
                System.out.println("STACK UNDERFLOW");
                return -1;
            } else {
                int val = data[tos];
                tos--;
                return val;
            }
        }

        int top() {
            if (tos == -1) {
                System.out.println("STACK UNDERFLOW");
                return -1;
            } else {
                return data[tos];
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack cs = new CustomStack(n);
        cs.push(1);
        cs.display();
        System.out.println(cs.top());  
        cs.push(2);
        cs.display();
        System.out.println(cs.top());     
        cs.push(3);
        cs.display();
        System.out.println(cs.top());          
        cs.push(4);
        cs.display();
        System.out.println(cs.top());     
        cs.pop();
        cs.display();
        System.out.println(cs.top());     
        cs.pop();
        cs.display();
        System.out.println(cs.top());     
        cs.pop();
        cs.display();
        System.out.println(cs.top());     
    }
}