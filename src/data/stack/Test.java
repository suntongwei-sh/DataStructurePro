package data.stack;

public class Test {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        for (int i = 0; i < 16; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack.toString());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.toString());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.toString());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.toString());
        System.out.println(arrayStack.peek());
    }
}
