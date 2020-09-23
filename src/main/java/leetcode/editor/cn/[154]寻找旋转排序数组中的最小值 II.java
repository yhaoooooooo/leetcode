//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 181 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int result = binarySearch(nums, 0, nums.length - 1);
        return result;
    }

    private int binarySearch(int[] nums, int left, int right) {

        if (left >= right) {
            return nums[right];
        }

        int mid = (left + right) / 2;
        int midNum = nums[mid];
        int leftNum = nums[left];
        int rightNum = nums[right];

        int result = 0;
        if (midNum >= leftNum) {
            if (leftNum < rightNum) {
                result = binarySearch(nums, left, mid);
            } else if (leftNum < rightNum) {
                result = binarySearch(nums, mid + 1, right);
            } else {
                int r1 = binarySearch(nums, mid + 1, right);
                int r2 = binarySearch(nums, left, mid);
                result = Math.min(r1, r2);
            }
        } else {
            result = binarySearch(nums, left, mid);
        }


        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
