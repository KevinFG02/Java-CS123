package Week1.Friday;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Kevin Flores
// 4/10/26
// CS123

public class StacksAndQueues {
    public static void main(String[] args){
        stackExamples();
        queueExamples();
    }

    public static void stackExamples(){
        Stack<Integer> stack1 = new Stack<>();

        stack1.push(5);
        stack1.push(1);
        stack1.push(23);
        stack1.push(53);
        stack1.push(34);

        System.out.println(stack1);
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        stack1.pop();
        System.out.println(stack1);
    }

    public static void queueExamples(){
        Queue<String> queue1 = new LinkedList<>();

        queue1.add("Blue");
        queue1.add("Red");
        queue1.add("Yellow");
        queue1.add("Green");

        while(!queue1.isEmpty()){
            System.out.println(queue1);
            String color = queue1.remove();
            System.out.println(color);
        }
    }
}
