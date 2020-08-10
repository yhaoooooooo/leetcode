//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 649 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution215 {

    public static void main(String[] args) {

        findKthLargest(new int[]{39, 291, 4, 3, 9, 999,30,22,1000}, 10);
    }

    public static int findKthLargest(int[] nums, int k) {

        quickSortNums(nums,0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
        return 0;
    }

    private static void quickSortNums(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int leftIndex = left;
        int rightIndex = right;
        int target = nums[left];
        while (left < right) {

            while (nums[right] >= target && left < right) {
                right--;
            }

//            if (right > left) {
                nums[left] = nums[right];
//            }

            while (nums[left] <= target && left < right) {
                left++;
            }
//            if (right > left) {
                nums[right] = nums[left];
//            }
        }

        nums[left] = target;
        quickSortNums(nums, leftIndex, left - 1);
        quickSortNums(nums, left+1, rightIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
