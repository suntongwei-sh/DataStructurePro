package data.tree;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> btree = new BinarySearchTree<Integer>();
        int[] ints = {28, 16, 30, 13, 22, 29, 42};

        for (int anInt : ints) {
            btree.add(anInt);
        }
       btree.preOrder();
       System.out.println("");
        btree.preOrderNR();
       System.out.println("");
        btree.levelOrder();
        System.out.println("");
        System.out.println(btree.maxnum());
        System.out.println(btree.minnum());
        btree.removeMax();
        System.out.println(btree.maxnum());
        btree.removeMin();
        System.out.println(btree.minnum());
        //  btree.inOrder();
       // btree.postOrder();
    }
}
