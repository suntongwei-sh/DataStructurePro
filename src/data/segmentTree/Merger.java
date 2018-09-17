package data.segmentTree;

/**
 * 两个元素怎么融合,可以有用户自定义
 * @param <E>
 */
public interface Merger<E> {

    E merger(E a, E b);
}
