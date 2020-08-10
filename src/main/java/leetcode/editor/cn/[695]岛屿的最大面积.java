package leetcode.editor.cn;//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 328 👎 0


import com.sun.glass.ui.Size;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {

    public static void main(String[] args) {
        int[][] data = new int[2][2];
        data[0] = new int[]{0, 1};
        data[1] = new int[]{1, 1};
//        data[2] = new int[]{0, 0, 0, 1, 1};
//        data[3] = new int[]{0, 0, 0, 1, 1};

        int i = maxAreaOfIsland(data);
        System.out.println(i);
    }


    public static int maxAreaOfIsland(int[][] grid) {

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        int max = 0;

        for (int i = 0; i < grid.length; i++) {


            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {

                    if (map.containsKey(i)) {
                        if (map.get(i).contains(j)) {
                            continue;
                        }
                    }
                    int tmp = 0;
                    if ((tmp = get(i, j, grid, map, 0)) > max) {
                        max = tmp;
                    }


                }
            }
        }
        return max;
    }


    public static int get(int x, int y,int[][] grid, Map<Integer, List<Integer>> map, int size) {

        if (grid[x][y] != 1) {
            return 0;
        }

        if (map.containsKey(x)) {
            if (map.get(x).contains(y)) {
                return 0;
            } else {
                map.get(x).add(y);
            }
        } else {
            map.put(x, new ArrayList<Integer>(Arrays.asList(y)));
        }
        size ++;



        if (x >= 1) {
            size += get(x - 1, y,grid, map, 0);
        }

        if (y >= 1) {
            size += get(x, y - 1, grid, map, 0);
        }

        if (x + 1 < grid.length) {
            size += get(x + 1, y, grid, map, 0);
        }
        if (y + 1 < grid[x].length) {
            size += get(x, y + 1, grid, map, 0);
        }
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
