//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1564 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {


    public static void main(String[] args) {


        Solution42 solution42 = new Solution42();
        int[] tmp = {5, 2, 1, 2, 1, 5};
        int trap = solution42.trap(tmp);
        System.out.println(trap);
    }

    public int trap(int[] height) {


        if (height == null || height.length <= 2) {
            return 0;
        }


        int i = 0;
        int flag = height[i];
        int position = 0;
        while (flag <= height[position + 1] && (position + 1) < height.length) {
            flag = height[position + 1];
            position++;
        }
        i = position;


        if (i == height.length - 1) {
            return 0;
        }

        int count = 0;
        while (i < height.length - 1) {
            position = findHigthPosition(i, height);

            if (height[i] >= height[position]) {
                int tmp = findHigthPosition(position, height);
                if (height[position] <= height[tmp]) {
                    findHigthPosition(tmp, height);
                }
            }










            if (position == -1) {
                break;
            }
            if (position > i) {
                int leftHeightPosition = height[i];
                int rigtHeigthPosition = height[position];
                int heigthT = leftHeightPosition > rigtHeigthPosition ? rigtHeigthPosition : leftHeightPosition;
                for (int j = i + 1; j < position; j++) {
                    if (height[j] >= heigthT) {
                        continue;
                    }
                    count = count + (heigthT - height[j]);
                }
            }
            i = position;
        }


        return count;
    }

    private int findHigthPosition(int i, int[] height) {

        int flag = height[i];
        int tmpPosition = i + 1;
        int position = 0;

        while (tmpPosition < height.length && flag >= height[tmpPosition]) {
            flag = height[tmpPosition];
            tmpPosition++;
        }

        tmpPosition--;
        if (tmpPosition == height.length - 1) {
            return -1;
        }


        while (tmpPosition < height.length && flag <= height[tmpPosition]) {
            flag = height[tmpPosition];
            tmpPosition++;
        }
        tmpPosition--;

        return position;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
