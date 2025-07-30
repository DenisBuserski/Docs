class Solution {
    public int[] twoSum(int[] nums, int target) {
                for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];

                if (current + next == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
