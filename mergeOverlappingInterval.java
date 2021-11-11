import java.util.*;

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class mergeOverlappingInterval {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Interval arr[] = new Interval[n];
        for (int i = 0; i < n; i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            arr[i] = new Interval(a, b);
        }

        mergeIntervals(arr);
        scn.close();
    }

    public static void mergeIntervals(Interval[] arr) {

        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int index = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[index].end >= arr[i].start) {
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            } else {
                index++;
                arr[index] = arr[i];
            }
        }

        System.out.println("The merged intervals are : ");

        for (int i = 0; i <= index; i++) {
            System.out.println("[ " + arr[i].start + " , " + arr[i].end + " ]");
        }

    }

}
