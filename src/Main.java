public class Main {

    public static void main(String[] args) {
        /** 基本类型 0**/
        int[] array1 = new int[10];
        int[] array2 = new int[]{1, 3, 4};
        System.out.println(array1.length);
        System.out.println(array2.length);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        for (int item : array2) {
            System.out.println(item);
        }
        /**引用类型数组,初始化null **/
        Integer[] integers = new Integer[10];
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
