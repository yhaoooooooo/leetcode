//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1532 👎 0

package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution032 {
    public int longestValidParentheses(String s) {

        if (s == null) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int[] dpi = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                dpi[i] = 0;
            } else {
                if (i - 1 < 0) {
                    dpi[i] = 0;
                } else {
                    int leftposition = i - dpi[i - 1] - 1;
                    if (leftposition < 0) {
                        dpi[i] = 0;
                    } else {
                        if (chars[leftposition] == '(') {
                            dpi[i] = 2 + dpi[i - 1] + (leftposition - 1 < 0 ? 0 : dpi[leftposition - 1]);
                        }
                    }
                }
            }

        }
        int maxLength = 0;
        for (int i : dpi) {
            maxLength = Math.max(maxLength, i);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
