//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 533 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length <= 0) {
            return 0;
        }

        int[][] dynamicData = new int[matrix.length][matrix[0].length];

        int maxSquare = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    dynamicData[i][j] = 0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    dynamicData[i][j] = 1;
                } else {
                    dynamicData[i][j] =
                            Math.min(Math.min(dynamicData[i - 1][j - 1], dynamicData[i - 1][j]), dynamicData[i][j - 1]) + 1;
                }
                maxSquare = Math.max(maxSquare, dynamicData[i][j]);
            }
        }

        return maxSquare * maxSquare;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
