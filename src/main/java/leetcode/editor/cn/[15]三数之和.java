package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2458 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listList = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int f = nums[i];

            if (f > 0) {
                break;
            }

            if (i > 1 && nums[i] == nums[i] - 1) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int s = nums[left];
                int t = nums[right];

                if (f + s + t == 0) {
                    //增加

                    while (s == nums[left + 1] && left < right) {
                        left++;
                    }
                    while (t == nums[right - 1] && left < right) {
                        right--;
                    }
                } else if (f + s + t > 0) {
                    right--;
                    while (t == nums[right - 1] && left < right) {
                        right--;
                    }
                } else {
                    left++;
                    while (s == nums[left + 1] && left < right) {
                        left++;
                    }
                }




            }
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
