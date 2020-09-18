//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学 
// 👍 183 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    private Map<Integer, Map<Integer, HashSet<Integer>>> map = new HashMap<>();

    public int maxPoints(int[][] points) {
        int max = 0;

        if (points.length == 1) {
            return 1;
        }

        if (points != null && points.length > 0) {
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int k = caculateGradient(points[i], points[j]);
                    int b = k == Integer.MAX_VALUE ? Integer.MIN_VALUE : (points[i][1] - points[i][0] * k);
                    if(!map.containsKey(k)){
                        map.put(k, new HashMap<Integer, HashSet<Integer>>());
                    }
                    Map<Integer, HashSet<Integer>> integerListMap = map.get(k);
                    HashSet<Integer> integers = null;
                    if (!integerListMap.containsKey(b)) {
                        integerListMap.put(b, new HashSet<Integer>());
                    }
                    integers = integerListMap.get(b);
                    integers.add(i);
                    integers.add(j);
                    max = Math.max(max, integers.size());
                }
            }
        }
        return max;
    }

    private int caculateGradient(int[] point1, int[] point2) {
        if (point1[0] - point2[0] == 0) {
            return Integer.MAX_VALUE;
        }
        return (point1[1] - point2[1]) / (point1[0] - point2[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
