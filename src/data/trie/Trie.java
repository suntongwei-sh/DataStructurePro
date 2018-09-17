package data.trie;

import java.util.TreeMap;

/**
 * 前缀树(字典树)-针对字符串搜索效率高
 * 复杂度(添加,查询只与字符串长度有关),与目前容量无关
 * 这里简单的针对字符串,不再使用泛型
 * 多叉树,容量越多,查询效率越高
 */
public class Trie {

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    /**
     * 向trie中添加字符串(单词)
     *
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        //遍历字符串中单词
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询是否包含 单词
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        //遍历字符串中单词
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        //最后一位必须是单词的结尾,才能确定包含
        return cur.isWord;
    }

    /**
     * 是否包含以此为前缀的单词
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        //遍历字符串中单词
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        //所有字母都匹配,则存在该前缀
        return true;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 内部节点结构
     */
    private class Node {
        //是否是某个单词结尾
        public boolean isWord;
        //下一个节点集合
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
}
