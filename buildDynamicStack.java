import java.io.*;

class buildDynamicStack {

    public static class DynamicStack {
        int[] data;
        int tos;

        public DynamicStack(int cap) {
            data = new int[cap];
            tos = -1;
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
                int[] ndata = new int[2 * data.length];

                for (int i = 0; i < data.length; i++) {
                    ndata[i] = data[i];
                }
                data = ndata;

                tos++;
                data[tos] = val;
            } else {
                tos++;
                data[tos] = val;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        DynamicStack cs = new DynamicStack(n);
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
