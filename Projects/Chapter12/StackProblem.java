class StackProblem {
    public static void main(String[] args) {
        IntStack stack = new IntStack();

        stack.push(3);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.empty();
        System.out.println(stack.empty());
    }
}