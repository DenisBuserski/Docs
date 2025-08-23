class Solution {
    public int findPeakElement(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            if (nums.length == 1) {
                result = i;
                break;
            }


            if (i == 0) {
                // First element
                int right = nums[i + 1];
                if (currentNumber > right) {
                    result = i;
                }
            } else if (i == nums.length - 1) {
                // Last element
                int left = nums[i - 1];
                if (currentNumber >= left) {
                    result = i;
                }
            } else {
                // Middle elements
                int right = nums[i + 1];
                int left = nums[i - 1];
                if (currentNumber >= right && currentNumber >= left) {
                    result = i;
                }

            }
        }

        return result;
    }
}
