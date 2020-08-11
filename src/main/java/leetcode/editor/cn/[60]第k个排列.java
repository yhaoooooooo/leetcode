//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 296 👎 0

package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution60 {

    public static void main(String[] args) {
        String permutation = getPermutation(4, 9);
        System.out.println(permutation);
    }

    private static List<String> ll = new ArrayList<String>();

    public static String getPermutation(int n, int k) {

        List<String> list = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        get("", list);

        Collections.sort(ll);

        return ll.get(k-1);
    }

    public static void get(String result, List<String> leftStrings){

       /* List<String> tmpList = new ArrayList<String>(leftStrings);
        if (!tmpList.isEmpty()) {
            Iterator<String> iterator = leftStrings.iterator();
            while (iterator.hasNext()) {
                String tmp = iterator.next();
                iterator.remove();
                get(result + tmp, tmpList);
            }
        } else{
            ll.add(result);
        }*/

        List<String> left = null;

        if (leftStrings.isEmpty()) {
            ll.add(result);
            return;
        }
        for (int i = 0; i < leftStrings.size(); i++) {

            left = new ArrayList<String>(leftStrings);
            String s = leftStrings.get(i);
            left.remove(s);
            get(result + s, left);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
