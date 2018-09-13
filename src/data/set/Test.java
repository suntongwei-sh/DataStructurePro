package data.set;

import java.util.Random;
import java.util.TreeSet;

/**
 * treeSet
 */
public class Test {

    public static void main(String[] args) {
        //jdk提供的 treeSet
        //过滤重复的
        TreeSet<Integer> es = new TreeSet();
        TreeSet<String> res=new TreeSet<String>();
        Random random = new Random();
        for (int i = 0; i <12 ; i++) {
            es.add(random.nextInt(100));
        }
        System.out.println(es.toString());
        res.add("AAA");
        res.add("AAA");
        System.out.println(res.toString());
    }
}
