//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3445 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    private List<Integer> mergeIntArr = new ArrayList<>();

    public List<Integer> getMergeIntArr() {
        return mergeIntArr;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr1 = new int[]{1,3};
//        int[] arr2 = new int[]{2};
//        double medianSortedArrays = solution.findMedianSortedArrays(arr1, arr2);
//        System.out.println(solution.getMergeIntArr());
//        System.out.println(medianSortedArrays);
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int middleIndex = (nums1.length + nums2.length) / 2;
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;

        // 遍历合并
//        mergeIntArrAndFindMiddleNum(nums1, nums2);
        // 归并
        if (!isOdd) {
            Integer integer = mergeIntArr.get(middleIndex-1);
            Integer integer2 = mergeIntArr.get(middleIndex);
            return ((double) (integer + integer2)) / 2;
        } else {
            Integer integer = mergeIntArr.get(middleIndex);

            return integer;
        }

    }

    private double mergeIntArrAndFindMiddleNum(int[] nums1, int[] nums2) {

        int aIndex = 0;
        int bIndex = 0;

        int mergedIndex = 0;
        while (aIndex < nums1.length && bIndex < nums2.length) {
            if (nums1[aIndex] > nums2[bIndex]) {
                mergeIntArr.add(nums2[bIndex]);
                bIndex++;
            } else {
                mergeIntArr.add(nums1[aIndex]);
                aIndex++;
            }
            mergedIndex++;
        }

        while (aIndex < nums1.length) {
            mergeIntArr.add(nums1[aIndex++]);
        }

        while (bIndex < nums2.length) {
            mergeIntArr.add(nums2[bIndex++]);
        }
        return 0;
    }

    private int getMiddleIndex(int length1, int length2) {
        return (length1 + length2) / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
