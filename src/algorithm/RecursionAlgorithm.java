package algorithm;

/**
 * 测试递归的本质
 */
public class RecursionAlgorithm {
    //提供给外部调用
    public static int sum(int[] array){
        return sum(array,0);
    }
    //真正的递归算法逻辑,对外屏蔽
    private static int sum(int[] arr,int offset){
        //最后一步返回值(最基本问题)
        if (offset== arr.length)
            return 0;
        //递归调用(将原问题转化成最小问题)
        return  arr[offset]+sum(arr,offset+1);
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        int sum = RecursionAlgorithm.sum(ints);
        System.out.println(sum);
    }

}
