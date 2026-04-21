package Week2.Friday.Queues;

import Week2.Friday.Stacks.Stack;

public class TestQueue {
    public static void main(String[] args){
        Queue<Integer> queue1 = new Queue<>();

        queue1.enQueue(23);
        queue1.enQueue(54);
        queue1.enQueue(1);

        System.out.println(queue1);

        System.out.println(queue1.deQueue());
        System.out.println(queue1.peek());
        System.out.println(queue1.deQueue());
        System.out.println(queue1.size());
    }
}
