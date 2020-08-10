//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 871 👎 0

package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
    }

    public static int search(int[] nums, int target) {

        if (nums.length <= 0) {
            return 0;
        }

        int index = binarySearch(0, nums.length - 1, nums, target);

        return index;
    }

    private static int binarySearch(int left, int right, int[] nums, int target) {
        /*if (left <= right) {

            int midIndex = (left + right) / 2;


            int midNum = nums[midIndex];
            int leftNum = nums[left];
            int rightNum = nums[right];


            if (midNum == target) {
                return midIndex;
            }


            if (nums[0] <= midNum) {
                if (target > midNum) {
                    return binarySearch(midIndex + 1, right, nums, target);
                } else {
                    return binarySearch(left, midIndex, nums, target);
                }
            } else {
                if (target > midNum) {
                    return
                }
            }


         *//*   if (midNum > target) {
                int index = binarySearch(left, midIndex, nums, target);
                if (index != -1) {
                    return index;
                }
                index = binarySearch(midIndex + 1, right, nums, target);
            }

            if (midNum < target) {

            }*//*

            *//*if (num < target && midIndex < right) {
                return binarySearch(midIndex + 1, right, nums, target);
            }
            if (num > target && midIndex > left) {
                return binarySearch(left, midIndex, nums, target);
            }*//*

        }*/
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
