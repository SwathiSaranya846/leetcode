import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // Store enqueue time, processing time and original index
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort tasks by enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap: processing time first, then original index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        int[] result = new int[n];

        int time = 0;
        int i = 0;
        int k = 0;

        while (k < n) {

            // Add all available tasks to the heap
            while (i < n && arr[i][0] <= time) {
                pq.offer(arr[i]);
                i++;
            }

            // If no task is available, move time forward
            if (pq.isEmpty()) {
                time = arr[i][0];
            } else {
                int[] task = pq.poll();

                result[k] = task[2];
                k++;

                time += task[1];
            }
        }

        return result;
    }
}