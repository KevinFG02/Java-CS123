package Week2.Friday.Stacks;

public class TestStack {
    public static void main(String[] args){
        Stack<Integer> stack1 = new Stack<>();

        stack1.push(23);
        stack1.push(54);
        stack1.push(1);

        System.out.println(stack1);

        System.out.println(stack1.pop());
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.size());
    }
}
