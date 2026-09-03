class Solution {
    public int maximumGap(int[] nums) {

        int n = nums.length;

        if (n < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int value : nums) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        if (min == max) {
            return 0;
        }

        // Calculate bucket size
        int bucketSize = Math.max(1, (max - min) / (n - 1));

        // Calculate number of buckets
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        // Put numbers into buckets
        for (int value : nums) {

            int index = (value - min) / bucketSize;

            bucketMin[index] = Math.min(bucketMin[index], value);
            bucketMax[index] = Math.max(bucketMax[index], value);
        }

        int answer = 0;
        int previousMax = min;

        // Calculate gaps
        for (int i = 0; i < bucketCount; i++) {

            // Skip empty bucket
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }

            int gap = bucketMin[i] - previousMax;

            answer = Math.max(answer, gap);

            previousMax = bucketMax[i];
        }

        return answer;
    }
}