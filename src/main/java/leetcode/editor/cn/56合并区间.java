package leetcode.editor.cn;
//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 559 👎 0


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution56 {
    public int[][] merge(int[][] intervals) {


        quickSortIntervals(intervals, 0, intervals.length - 1);

        int[][] result = splitArray(intervals, 0, intervals.length - 1);

        return null;
    }

    private int[][] splitArray(int[][] intervals, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int[][] leftArray = splitArray(intervals, left, mid);
            int[][] rightArray = splitArray(intervals, mid + 1, right);
            return mergeArray(leftArray, rightArray);
        } else {
            int[][] result = new int[1][2];
            result[0] = intervals[left];
            return result;
        }
    }

    private int[][] mergeArray(int[][] leftArray, int[][] rightArray) {

        int leftMin = leftArray[leftArray.length - 1][0];
        int leftMax = leftArray[leftArray.length - 1][1];

        int rightMin = rightArray[0][0];
        int rightMax = rightArray[0][1];

        boolean needMerge = false;
        if (rightMin <= leftMax) {
            needMerge = true;
        }

        int[][] result = new int[needMerge ? leftArray.length + rightArray.length - 1 : leftArray.length + rightArray.length][2];

        int i=0;
        while (i < (needMerge ? leftArray.length - 1 : leftArray.length)) {
            result[i] = leftArray[i];
            i++;
        }
        if (needMerge) {
            result[i][0] = leftMin;
            result[i][1] = leftMax >= rightMax ? leftMax : rightMax;
            i++;
        }

        int j= needMerge ? 1 : 0;
        while (j < rightArray.length) {
            result[i] = rightArray[j];
            j++;
        }

        return result;
    }

    private void quickSortIntervals(int[][] intervals, int left, int right) {

        if (left < right) {

            int tmp = intervals[left][0];
            int[] leftTArray = intervals[left];
            int leftT = left;
            int rightT = right;


            while (left < right) {

                while (left < right && intervals[right][0] >= tmp) {
                    right--;
                }

                intervals[left] = intervals[right];

                while (left < right && intervals[left][0] < tmp) {
                    left++;
                }
                intervals[right] = intervals[left];
            }

            intervals[left] = leftTArray;

            quickSortIntervals(intervals, leftT, left);
            quickSortIntervals(intervals, left + 1, right);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
