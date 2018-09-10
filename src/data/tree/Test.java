package data.tree;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> btree = new BinarySearchTree<Integer>();
        int[] ints = {3, 7, 4, 1, 6, 2, 5};

        for (int anInt : ints) {
            btree.add(anInt);
        }
       // btree.preOrder();
        System.out.println(btree);
    }
}
