//给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。 
//
// 
//
// 示例 1: 
//
// 输入: [1,3,5,4,7]
//输出: 3
//解释: 最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
// 
//
// 示例 2: 
//
// 输入: [2,2,2,2,2]
//输出: 1
//解释: 最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 注意：数组长度不会超过10000。 
// Related Topics 数组 
// 👍 98 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution647 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,6,7}));
    }
    public static int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0, j = 1; i < nums.length; j++) {
            int index = i;
            while (j < nums.length  && nums[index] < nums[j]  ) {
                index++;
                j++;
            }
            int length = j - i;
            if (length > max) {
                max= length;
            }
            i = j;
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
