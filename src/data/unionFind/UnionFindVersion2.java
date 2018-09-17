package data.unionFind;

public class UnionFindVersion2 implements UnionFind {
    //parent[i]表示父节点的索引
    private int[] parent;
    public UnionFindVersion2(int size){
        this.parent=new int[size];
        //初始状态,父节点都是自己的index
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }




    /**
     * 是否相连(查)
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }
    //循环向上查找根节点
    private int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 两个元素合并
     *
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int ip = find(p);
        int iq = find(q);
        if (ip != iq) {
            //使两个集合id值相同,集合合并(更改父节点)
            parent[ip] = iq;
        }
    }

    @Override
    public int size() {
        return parent.length;
    }
}
