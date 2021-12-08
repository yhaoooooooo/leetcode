//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
// 1 * ((3 - 1) *
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2186 👎 0

package leetcode.editor.cn;


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {


        int left = 0;
        int right = 0;
        List<String> result = new ArrayList<>();
        result.addAll(getKuoHao("",left, right, n));


        return result;
    }

    private List<String> getKuoHao(String str, int left, int right, int total) {

        if (left == total && right == total) {
            return Arrays.asList(str);
        }
        List<String> result = new ArrayList<>();
        if (left == right) {
            result.addAll(getKuoHao(str +"(", left + 1,  right, total));
        } else if (left > right){
            if (left < total) {
                result.addAll(getKuoHao(str + "(", left + 1, right, total));
            }
            result.addAll(getKuoHao(str + ")", left, right + 1, total));
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
