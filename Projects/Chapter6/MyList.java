/*Below is an example of an "inner class," i.e. the definition of one class
nested inside another*/

public class MyList {
    private ListElement head, tail;    //inner class
    void add(Object value){                  
        if(tail != null) {
            tail.next = new ListElement(value);   //inner class
            tail = tail.next;
        }
        else {
            head = tail = new ListElement(value); //inner class
        }
    }

    Object remove() {
        assert head != null;
        Object result = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return result;
    }

    private class ListElement {
        ListElement(Object value) {
            this.value = value;
            Object value;
            ListElement next;
        }

    }
}