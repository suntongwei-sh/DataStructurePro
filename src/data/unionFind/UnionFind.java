package data.unionFind;

/**
 * 并查集接口
 */
public interface UnionFind {
    /**
     * 是否相连(查)
     * @param a
     * @param b
     * @return
     */
    boolean isConnected(int p,int q);

    /**
     * 两个元素合并
     * @param p
     * @param q
     */
    void union(int p,int q);

    int size();
}
