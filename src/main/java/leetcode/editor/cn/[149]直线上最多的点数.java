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
class Solution149 {


    private Map<Double, Map<Double, HashSet<Double>>> map = new HashMap<>();

    public int maxPoints(int[][] points) {
        int max = 0;

        if (points.length == 1) {
            return 1;
        }

        if (points != null && points.length > 0) {
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1 ; j < points.length; j++) {
                    double k = caculateGradient(points[i], points[j]);
                    double b = k == Double.MAX_VALUE ? points[i][0] : (points[i][1] - points[i][0] * k);
                    if(!map.containsKey(k)){
                        map.put(k, new HashMap<Double, HashSet<Double>>());
                    }
                    Map<Double, HashSet<Double>> integerListMap = map.get(k);
                    if (!integerListMap.containsKey(b)) {
                        integerListMap.put(b, new HashSet<Double>());
                    }
                    HashSet<Double> integers  = integerListMap.get(b);
                    integers.add(Double.valueOf(i));
                    integers.add(Double.valueOf(j));

                    max = Math.max(max, integers.size());
//                    if (integers.size() == 21) {
//                        System.out.println(k);
//                        System.out.println(b);
//                    }
                }
            }
        }
        System.out.println(map.get(0.4142857142857143));
        return max;
    }

    private double caculateGradient(int[] point1, int[] point2) {
        if (point1[0] == point2[0] ) {
            return Double.MAX_VALUE;
        }
        return (double)(point1[1] - point2[1]) / (point1[0] - point2[0]);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
