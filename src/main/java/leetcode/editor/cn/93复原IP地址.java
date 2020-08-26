package leetcode.editor.cn;
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法 
// 👍 317 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution8 {

    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
        System.out.println(list);
    }

    public static List<String> restoreIpAddresses(String s) {
        function("", s, 0);


        return list;
    }

    public static String function(String ready, String left, int position) {

        if (position < 3) {
            position++;

            String tmp = ready;
            String substring = left.substring(0, 1);
            ready = tmp + "." + substring;
            String value = function(ready, left.substring(1), position);
            if ( value  != null) {
                list.add(value);
            }

            substring = left.substring(0, 2);
            ready = tmp + "." + substring;
            value = function(ready, left.substring(2), position);

            if ( value  != null) {
                list.add(value);
            }

            substring = left.substring(0, left.length() < 3 ? left.length() : 3);
            if (Integer.valueOf(substring) <= 255) {
                ready = tmp + "." + substring;
                value = function(ready, left.substring(left.length() >= 3 ? 3 : left.length()), position);
                if (value != null) {
                    list.add(value);
                }
            }
        }

        if (left != null && !left.equals("") && left.length() <= 3 && Integer.valueOf(left) <= 255) {
            return ready + "." + left;
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
