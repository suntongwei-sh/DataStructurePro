package data.linked;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 8; i++) {
            linkedList.addLast(i);
        }
        System.out.println(linkedList);
        linkedList.add(1,25);
        System.out.println(linkedList);
        linkedList.addFirst(26);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);




    }
}
