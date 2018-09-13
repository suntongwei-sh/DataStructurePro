package data.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树(二叉树的一种) 节点不一定都是满的
 * 特点: 1.每个节点的值:
 *      大于左子树的所有节点的值
 *  *      小于右子树的所有节点的值
 *      如果有重复元素,不做任何操作
 *  2.每一颗子树也是二分搜索树
 *  3.存储的元素具有可比性(为了存储结构)(E extends Comparable<E>)
 *
 * 一直往左走,一定是最小值
 * 往右走,一定最大值
 *
 */

/**
 * 复杂度  n 元素个数
 * O(h)   h  树的高度
 * 平均(满树)   O(log(n))
 * 最差(退化成链表)   O(n)
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node root;//根节点
    private int size;//元素数量

    public BinarySearchTree() {
        root=null;
        size=0;
    }

    /**
     *前序遍历(先遍历节点,再遍历子树)
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历(递归)
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
     * 非递归前序遍历(借助栈)
     * 中序,后序非递归实现并不常用
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                //先压入右元素(后出)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 广度优先(层序)遍历(借助队列)
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left!=null){
                queue.add(cur.left);
            }
            if (cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * 递归寻找最小元素
     * @return
     */
    public E minnum() {
        if (isEmpty())
            throw new RuntimeException(" is empty");
        return minnum(root).e;
    }

    private Node minnum(Node node) {
        if (node.left == null)
            return node;
        return minnum(node.left);
    }
    /**
     * 递归寻找最大元素
     * @return
     */
    public E maxnum() {
        if (isEmpty())
            throw new RuntimeException(" is empty");
        return maxnum(root).e;
    }

    private Node maxnum(Node node) {
        if (node.right == null)
            return node;
        return maxnum(node.right);
    }

    /**
     * 删除最小值
     * @return
     */
    public E removeMin() {
        //返回最小值
        E minnum = minnum();
        //删除,重新给root赋值
        root = removeMin(root);
        return minnum;
    }
    //递归删除(右侧)
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大值
     * @return
     */
    public E removeMax() {
        //返回最小值
        E maxnum = maxnum();
        //删除,重新给root赋值
        root = removeMax(root);
        return maxnum;
    }
    //递归删除(右侧)
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除任意值
     * @param e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return node;
        //在左侧删除
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
            //在右侧删除
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            //当前节点就是要删除的
            //左侧为空,保留右侧
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //又侧为空,保留左侧
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //当前节点左子树,右子树都存在时;
            //需要重新构建子树(两种方法)
            //步骤:(后继) 在该节点右子树中比该节点大的第一个元素节点(即 最近右节点的左节点)
            //或者(前驱) 在该节点左子树中取最大的元素
            Node successor = minnum(node.right);//右子树中寻找最小值节点
            successor.right=removeMin(node.right);//删除该节点,构建右子树
            size++;
            successor.left=node.left;//构建左子树
            node.left=node.right=null;//原节点删除
            size--;
            return successor;
        }
    }

    /**
     * 中序遍历(从小到大排序遍历)
     */
    public void  inOrder(){
        inOrder(root);
    }
    /**
     * 递归中序遍历
     */
    private void inOrder(Node node) {
        if (null==node)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }
    /**
     * 后序遍历(递归)
     */
    private void postOrder(Node node) {
        if (node==null)
            return;
        inOrder(node.right);
        inOrder(node.left);
        System.out.println(node.e);

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
//        if (null==root){
//            root=new Node(e);
//            size++;
//        }else
            //递归操作插入新元素
            root=  add(root,e);
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
            //链接新创建的节点(左子树)
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {//e.compareTo(node.e) > 0
            //链接新创建的节点(又子树)
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
