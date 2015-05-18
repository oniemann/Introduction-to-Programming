public class IntStack {
    //returns value of the top of the stack
    int top() {
        if (top != null) 
            return top.data;
        else
            return 0;
    } 

    //removes value of top of stack after returning value
    /*if top doesn't equal zero, the value at the top of the stack points to the
    next element on the list. This, in turn, removes what was the next element on
    the list.*/
    int pop() {
        int result = top();

        if (top != null)
            top = top.next;

        return result;
    }

    //adds one to the stack
    void push(int value) {
        if (top == null) {
            top = new IntListElement(value);
        }

        else {
            //create a new value/element
            IntListElement temp = new IntListElement(value);
            //set its link to next element being current top
            temp.next = top;
            //top is then redefined to be the new value
            top = temp;

            //from above, a new value is created and the put on top of the stack
        }
    }

    boolean empty() {
        return top == null;
    }

    public String toString() {
        return ("Top of Stack: " + top());
    }

    private IntListElement top = null;
}