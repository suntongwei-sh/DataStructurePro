package data.unionFind;

/**
 * 数组模拟并查集
 * quick find比较高效
 */
public class UnionFindVersion1 implements UnionFind {

    private int[] id;

    public UnionFindVersion1(int size) {
        this.id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private int find(int p) {
        if (p < 0 || p > id.length)
            throw new IllegalArgumentException();
        return id[p];
    }

    /**
     * 是否相连(查)
     * 此时O(1) 是高效的
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 两个元素合并
     * 此时O(n),效率低
     *
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int ip = find(p);
        int iq = find(q);
        if (ip != iq) {
            //使两个集合id值相同,集合合并
            for (int i = 0; i < id.length; i++) {
                if (id[i] == ip)
                    id[i] = iq;
            }
        }
    }

    @Override
    public int size() {
        return id.length;
    }
}
