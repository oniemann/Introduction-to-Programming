class List {
    ListElement current, head, previous;

    void insert(Object value) {
        previous = current;

        //if there is already a list in place
        if (current != null) {
            ListElement next = current.next;
            current.next = new ListElement(value);
            current = current.next;
            current.next = current;
        }

        //if there is no current value, insert at the head
        else if (head != null) {
            current = new ListElement(value);
            current.next = head;
            head = current;
        }

        //if there does not exist a list, create one!
        else
            head = current = new ListElement(value);
    }

    Object next() {
        previous = current;

        //if current isn't declared, spit out the value of head
        if (current == null) {
            current = head;
        }

        //else continue to the next indice
        else {
            current = current.next;
        }
        return current.data;
    }

    Object current() {
        return current.data;
    }

    void remove() {
        if (head == null) return;
        if (current == null) return;
        if (current == head) {
            head = current = current.next;
        }
        else
            current = previous.next = current.next;
    }

    void movetohead() {
        previous = current = null;
    }

    boolean hasNext() {
        if (current != null)
            return current.next != null;
        else 
            return head.next != null;
    }

    public String toString() {        

        ListElement cursor = head;
        StringBuffer result = new StringBuffer("");

        while (cursor != null) {
            result.append(cursor.data + "\n");
            cursor = cursor.next;
        }

        return result.toString();
    }
}