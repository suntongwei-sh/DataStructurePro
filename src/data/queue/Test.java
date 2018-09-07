package data.queue;

public class Test {

    public static void main(String[] args) {
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<Integer>(12);
        for (int i = 0; i < 8; i++) {
            integerArrayQueue.enQueue(i);
        }

        System.out.println(integerArrayQueue);
        //出队
        integerArrayQueue.deQueue();
        System.out.println(integerArrayQueue);
        System.out.println(integerArrayQueue.getFront());


    }
}
