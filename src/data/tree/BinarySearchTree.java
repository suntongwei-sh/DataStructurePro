package data.tree;


/**
 * 二分搜索树(二叉树的一种) 节点不一定都是满的
 * 特点: 1.每个节点的值:
 *      大于左子树的所有节点的值
 *      小于右子树的所有节点的值
 *      如果有重复元素,不做任何操作
 *  2.每一颗子树也是二分搜索树
 *  3.存储的元素具有可比性(为了存储结构)
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node root;//根节点
    private int size;//元素数量

    public BinarySearchTree() {
        root=null;
        size=0;
    }

    public void preOrder(){
        preOrder(root);
    }

    /**
     * 递归遍历
     * @param node
     */
    private void preOrder(Node node) {
        if (null != node) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 查询
     *
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归查询操作
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node,E e) {
        if (node == null)
            return false;
        else if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }
    /**
     * 添加元素
     *
     * @param e
     * 添加节点规则:
     *   大于左子树的所有节点的值
     *   小于右子树的所有节点的值
     *   如果有重复元素,不做任何操作
     */

    public void add(E e){
        if (null==root){
            root=new Node(e);
            size++;
        }else
            //递归操作插入新元素
            add(root,e);
    }

    /**
     *
     * @param node
     * @param e
     */
    private Node add(Node node,E e) {
        //递归终止条件
        if (null == node) {
            size++;
            return new Node(e);
        }
        //递归插入新元素
        if (e.compareTo(node.e) < 0) {
            //链接新创建的节点
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {//e.compareTo(node.e) > 0
            node.right = add(node.right, e);
        }
        return node;
    };


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 定义内部节点类型
     * @param <E>
     */
    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(e+" ");
        }
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        generateString(root,0,sb);
        return sb.toString();
    }

    private void generateString(Node root, int depth, StringBuilder sb) {
            if (null==root){
                sb.append(generateDepthString(depth)+"null\n");
                return ;
            }
        sb.append(generateDepthString(depth)+root.e+"\n");
        generateString(root.left,depth+1,sb);
        generateString(root.right,depth+1,sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <depth ; i++) {
            sb.append("--");
        }

        return sb.toString();
    }

}
