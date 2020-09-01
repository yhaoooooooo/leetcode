//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,4,-3,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2348 👎 0

package leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    /**
     * O(n) 动态规划
     *
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        int maxValue = Integer.MIN_VALUE;
//        int[] dynamicData = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                dynamicData[0] = nums[i];
//            } else {
//                dynamicData[i] = nums[i] + (dynamicData[i - 1] < 0 ? 0 : dynamicData[i - 1]);
//            }
//            maxValue = Math.max(dynamicData[i], maxValue);
//        }
//        return maxValue;
//    }
    /*public int maxSubArray(int[] nums) {

        int begin = 0;
        int end = nums.length - 1;
        int[] dynamicData = new int[nums.length];
        function(nums, begin, end, dynamicData);

        return 0;
    }

    private void function(int[] nums, int begin, int end, int[] dynamicData) {

        if (begin >= end) {
            dynamicData[begin] = nums[begin];

        } else {
            int mid = (begin + end) / 2;
            function(nums, begin, mid, dynamicData);
            function(nums, mid + 1, end, dynamicData);

            if (dynamicData)

        }

    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
