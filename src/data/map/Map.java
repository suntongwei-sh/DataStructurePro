package data.map;

/**
 * 映射(字典)接口
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> {
    /**
     * 添加新的k v
     *
     * @param k
     * @param v
     */
    void add(K k, V v);

    /**
     * 删除K和对应的值V
     * 返回V
     *
     * @param k
     * @return
     */
    V remove(K k);

    /**
     * 大小
     *
     * @return
     */
    int getSize();


    /**
     * 是否包含k
     *
     * @param k
     * @return
     */
    boolean contains(K k);

    boolean isEmpty();

    /**
     * 获取K 对应的V
     *
     * @param k
     * @return
     */
    V get(K k);

    /**
     * 更新k对应的V
     *
     * @param k
     * @param v
     */
    void set(K k, V v);
}
