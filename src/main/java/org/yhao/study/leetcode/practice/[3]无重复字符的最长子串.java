//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4082 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package org.yhao.study.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

class WuChongfuZifuZuichangZiChuan {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() <= 0) {
            return 0;
        }


        return 0;
    }


    public Byte[] splitAndMerge(byte[] str, int left, int right) {

        List<Byte> list = new ArrayList<Byte>();
        if (left < right) {
            int mid = (left + right) / 2;
            Byte[] leftArr = splitAndMerge(str, left, mid);
            Byte[] rightArr = splitAndMerge(str, mid + 1, right);

            merg(leftArr, rightArr, list);

        }
        //当拆分到一个字符的时候，直接返回
        list.add(str[left]);
        return list.toArray(new Byte[list.size()]);
    }

    private void merg(Byte[] leftArr, Byte[] right, List<Byte> list) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
