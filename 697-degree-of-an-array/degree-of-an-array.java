import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        // Find frequency and first/last occurrence
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            count.put(num, count.getOrDefault(num, 0) + 1);

            if (!first.containsKey(num)) {
                first.put(num, i);
            }

            last.put(num, i);

            degree = Math.max(degree, count.get(num));
        }

        int result = nums.length;

        // Find the shortest subarray with the same degree
        for (int num : count.keySet()) {

            if (count.get(num) == degree) {

                int length = last.get(num) - first.get(num) + 1;

                result = Math.min(result, length);
            }
        }

        return result;
    }
}