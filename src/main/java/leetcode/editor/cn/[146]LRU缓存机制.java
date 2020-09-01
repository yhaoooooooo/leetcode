//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 845 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
//class LRUCache {
//    private final int capacity;
//    private LinkedHashMap<Integer, Integer> cache = null;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        cache = new LinkedHashMap<Integer, Integer>(){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > LRUCache.this.capacity;
//            }
//        };
//    }
//
//    public int get(int key) {
//        return this.cache.get(key);
//    }
//
//    public void put(int key, int value) {
//        this.cache.put(key, value);
//    }
//
//}

class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1,1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }


    class CacheNode{
        CacheNode next;
        CacheNode pre;
        int value;
        int key;
        CacheNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    private HashMap<Integer, CacheNode> cache ;
    private int capacity = 0;
    private CacheNode head;
    private CacheNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, CacheNode>(capacity);
        head = new CacheNode(0,0);
        tail = new CacheNode(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        CacheNode cacheNode = cache.get(key);

        if (cacheNode == null) {
            return -1;
        }

        cacheNode.pre.next = cacheNode.next;
        cacheNode.next.pre = cacheNode.pre;
        CacheNode pre = tail.pre;
        pre.next = cacheNode;
        tail.pre = cacheNode;
        cacheNode.pre = pre;
        cacheNode.next = tail;
        return cacheNode.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            CacheNode cacheNode = cache.get(key);
            cacheNode.value = value;
            get(key);
            return;
        }

        CacheNode cacheNode = new CacheNode(key, value);
        cache.put(key, cacheNode);
        CacheNode pre = tail.pre;
        pre.next = cacheNode;
        cacheNode.pre = pre;
        cacheNode.next = tail;
        tail.pre = cacheNode;

        if (cache.size() > capacity) {
            CacheNode next = head.next;
            head.next = next.next;
            next.next.pre = head;
            cache.remove(next.key);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
