package data.map;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestMap {
    public static void main(String[] args) {
        LinkedListMap<Integer, String> linkedListMap = new LinkedListMap<Integer, String>();
        for (int i = 0; i < 12; i++) {
            linkedListMap.add(i, String.valueOf(i) + "S");
        }

        System.out.println(linkedListMap.toString());
        LinkedListMap<String, String> stringStringLinkedListMap = new LinkedListMap<String, String>();
        System.out.println(stringStringLinkedListMap);
        BSTMap<String, String> stringStringBSTMap = new BSTMap<String, String>();
        stringStringBSTMap.add("SSS", "BBB");
        System.out.println(stringStringBSTMap.getSize());
        System.out.println(stringStringBSTMap.get("SSS"));
        System.out.println(stringStringBSTMap.remove("SSS"));
        System.out.println(stringStringBSTMap.getSize());//
        //查找两个数组交集(去重)
        int[] array1 = {1, 2, 2, 3};
        int[] array2 = {1, 2};
        //先去重放入TreeSet
        TreeSet<Integer> integers = new TreeSet<Integer>();
        for (Integer integer : array1) {
            integers.add(integer);
        }
        ArrayList<Integer> integers1 = new ArrayList<Integer>();
        for (int i : array2) {
            if (integers.contains(i)) {
                //放入返回的
                integers1.add(i);
                //为了返回去重 将相同的值删除,下次contains就返回false;
                integers.remove(i);
            }
        }
        System.out.println(integers1);
        /** *********************************************************************** **/
        //查找两个数组交集(不去重)
        int[] array_1 = {1, 2, 2, 3};
        int[] array_2 = {1, 2, 2, 3};
        TreeMap<Integer, Integer> TreeMap = new TreeMap<Integer, Integer>();// 元素 ,出现次数
        for (int i : array_1) {
            if (TreeMap.containsKey(i)) {
                //已经包含,次数+1;
                TreeMap.put(i, TreeMap.get(i) + 1);
            } else {
                //未包含,put
                TreeMap.put(i, 1);
            }
        }
        ArrayList<Integer> integers_1 = new ArrayList<Integer>();
        for (int i : array_2) {
            if (TreeMap.containsKey(i)) {
                integers_1.add(i);
                //交集合并的次数-1
                int i1 = TreeMap.get(i) - 1;
                if (i1 == 0) {//为0  则删除key
                    TreeMap.remove(i);
                } else
                    TreeMap.put(i, i1);//交集合并的次数-1,更新
            }
        }
        System.out.println(integers_1);

    }
}
