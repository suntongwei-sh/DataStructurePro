package data.array;

public class Test {
    public static void main(String[] args) {
        Array array = new Array<Integer>(2);
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        array.add(3, 11);
        System.out.println(array.toString());
        array.removeLast();
        System.out.println(array.toString());
        Integer.valueOf("0012");
        System.out.println(Integer.valueOf("0012"));

    }
}
