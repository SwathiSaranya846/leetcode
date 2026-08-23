class Solution {
    public int longestMountain(int[] arr) {

        int n = arr.length;
        int maxLength = 0;

        for (int i = 1; i < n - 1; i++) {

            // Check for peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {

                int left = i;
                int right = i;

                // Move left
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Move right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                int length = right - left + 1;

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}