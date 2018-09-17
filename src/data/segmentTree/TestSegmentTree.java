package data.segmentTree;

public class TestSegmentTree {
    public static void main(String[] args) {
        Integer[] integers = {1, 3, 6, 2, 7, 8};
        SegmentTree<Integer> integerSegmentTree = new SegmentTree<Integer>(integers, new Merger<Integer>() {
            @Override
            public Integer merger(Integer a, Integer b) {
                return a + b;//对于integer  融合表示两者的和
            }
        });
        //使用拉lambads表达式传入匿名类
        //SegmentTree<Integer> integerSegmentTree = new SegmentTree<Integer>(integers, (a,b)->a+b);
        System.out.println(integerSegmentTree.toString());
        //针对原数组,区间查询(这里是求和)[index,index]
        System.out.println(integerSegmentTree.query(1, 5));

    }
}
