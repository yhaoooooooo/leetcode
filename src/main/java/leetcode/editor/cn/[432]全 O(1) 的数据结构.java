//请你实现一个数据结构支持以下操作： 
//
// 
// Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。 
// Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任
//何事情。key 保证不为空字符串。 
// GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。 
// GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。 
// 
//
// 
//
// 挑战： 
//
// 你能够以 O(1) 的时间复杂度实现所有操作吗？ 
// Related Topics 设计 
// 👍 63 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class AllOne {


    Map map = new HashMap(16);


    /** Initialize your data structure here. */
    public AllOne() {

    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {

    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {

        return null;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {

        return null;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)
