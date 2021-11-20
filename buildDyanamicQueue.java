class buildDyanamicQueue {
    public static class DynamicQueue {
        int[] data;
        int size;
        int front;

        public DynamicQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void add(int val) {
            if (size == data.length) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < size; i++) {
                    int index = (front + i) % data.length;
                    ndata[i] = data[index];
                }
                data = ndata;
                front = 0;

                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;

            } else {
                int index = (front + size) % data.length;
                data[index] = val;
                size++;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("QUEUE UNDERFLOW");
                return -1;
            } else {
                return data[front];
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("QUEUE UNDERFLOW");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        void dislpay() {
            for (int i = 0; i < size; i++) {
                int index = (front + i) % data.length;
                System.out.print(data[index] + " ");
            }
            System.out.println();
        }
    }
}
