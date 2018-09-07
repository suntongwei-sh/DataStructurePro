package data.stack;

import data.stack.LinkedListStack;

public class TestLinkedListStack {

    public static void main(String[] args) {
        LinkedListStack objectLinkedListStack = new LinkedListStack<Integer>();

        for (int i = 0; i < 6; i++) {
            objectLinkedListStack.push(i);
        }

        System.out.println(objectLinkedListStack);

        objectLinkedListStack.pop();
        System.out.println(objectLinkedListStack);
        System.out.println(  objectLinkedListStack.peek());
    }
}
