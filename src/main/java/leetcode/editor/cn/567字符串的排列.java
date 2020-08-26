package leetcode.editor.cn;
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 160 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedInputStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {

    public static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(checkInclusion("assda", "sdaaz"));
        System.out.println(list);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        return function("", s1, s2);
    }


    public static boolean function(String left, String right, String s2) {
        if (right.length() > 0) {
            for (int i=0; i<right.length(); i++) {

                char s = right.toCharArray()[i];
                if (!s2.contains(left + s)) {
                    return false;
                }
                System.out.println(left + s);
                System.out.println(right.substring(0,i) + right.substring(i + 1));
                if(function(left + s, right.substring(0,i) + right.substring(i + 1), s2)){
                    return true;
                } else {
                    continue;
                }
            }
        }
        list.add(left);
        return s2.contains(left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
