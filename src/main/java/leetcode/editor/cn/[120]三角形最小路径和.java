//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 579 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        List<Integer> sum = new ArrayList<Integer>(triangle.size());
        int position = 0;
        for (int i = 0; i < triangle.size(); i++) {
            int min = findMinNum(triangle.get(i), position);
            if (i == 0) {
                sum.add( min);
            } else {
                sum.add( sum.get(i - 1) + min);
            }
        }

        return sum.get(sum.size() - 1);
    }

    private int findMinNum(List<Integer> integers, int position) {
        int firstNum = integers.get(position);
        int secondNum = Integer.MAX_VALUE;
        if (position + 1 < integers.size()) {
            secondNum = integers.get(position + 1);
        }
        return firstNum > secondNum ? secondNum : firstNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
