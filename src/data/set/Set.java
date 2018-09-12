package data.set;

/**
 *
 * 定义集合接口
 *
 * @param <E>
 */
public interface Set<E> {
    /**
     * 集合中添加一个元素
     *
     * @param e
     */
    void add(E e);

    /**
     * 集合中删除一个元素
     *
     * @param e
     */
    void remove(E e);

    /**
     * 是否包含给定的元素
     *
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 集合的元素个数
     *
     * @return
     */
    int size();

    /**
     * 集合是否为空
     *
     * @return
     */
    boolean isEmpty();


}
