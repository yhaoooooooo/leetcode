//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package leetcode.editor.cn;
class Solution {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abc"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length <= 0) {
            return "";
        }


        String firtStr = strs[0];
        String commonStr = "";
        for (int i = 1; i <= firtStr.length(); i++) {
            String tmpCommon = firtStr.substring(0, i);
            boolean containCommon = true;
            for (int j = 1; j < strs.length; j++) {
                String tmp = strs[j];
                if (tmp.length() < tmpCommon.length()) {
                    containCommon = false;
                    break;
                }
                if (!tmp.substring(0, i).equals(tmpCommon)) {
                    containCommon = false;
                    break;
                }
            }
            if (containCommon) {
                commonStr = tmpCommon;
            }
        }

        return commonStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
