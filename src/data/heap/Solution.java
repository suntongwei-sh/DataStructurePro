package data.heap;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    /**
     * 辅助类 记录元素和频次
     */
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        //实现可比较性
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> method(int[] nums, int k) {
        //统计数组中各元素的频次,放入Map
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int num : nums) {
            if (treeMap.containsKey(num))
                treeMap.put(num, treeMap.get(num) + 1);
            else
                treeMap.put(num, 1);
        }

        // MaxHeap<Freq> maxHeap=new MaxHeap<Freq>();
        //创建优先队列,放入Freq
        PriorityQueue<Freq> freqPriorityQueue = new PriorityQueue<Freq>();
        Set<Integer> keySet = treeMap.keySet();
        for (Integer key : keySet) {
            //如果队列大小小于要求的前几名,继续入队
            if (freqPriorityQueue.getSize() < k) {
                freqPriorityQueue.enQueue(new Freq(key, treeMap.get(key)));
                //如果要求的前几名已满,则比较新的与队首的优先级, 新元素优先级高的话 则出队,新元素入队
            } else if (treeMap.get(key) > freqPriorityQueue.getFront().freq) {
                freqPriorityQueue.deQueue();
                freqPriorityQueue.enQueue(new Freq(key, treeMap.get(key)));
            }
        }
        List<Integer> integers = new LinkedList<Integer>();
        //依次出队
        while (!freqPriorityQueue.isEmpty()) {
            integers.add(freqPriorityQueue.deQueue().e);
        }
        return integers;
    }

    public static void main(String[] args) {
        //jdk 的优先队列<内部使用的是最小堆>
        PriorityQueue<Integer> pq = new PriorityQueue();
        //可以传入比较器自定义 Comparator<? super E> comparator;
        //更加的灵活
        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
    }
}
