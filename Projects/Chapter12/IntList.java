class IntList {
    private IntListElement head, current, previous;
    //head: first element in list
    //current: can refer to any element in the list
    //previous: points to element before current

    void insert(int value) {
        previous = current;

        //current is pointing to some element in the list
        //take current to equal 2
        //trying to insert 25 between 2 and 3
        if(current != null) {
            //next refers to 3, the third element in the list
            IntListElement next = current.next;
            //current.next is the next element (25)
            current.next = new IntListElement(value);
            //current then takes on this new value inserted
            current = current.next;
            //the values after this new current is the beginning of the rest of the list
            current.next = next;
        }

        //current isn't pointing to any element but the list isn't empty
        else if (head != null) {
            //creates value for current
            current = new IntListElement(value);
            //the next element after current becomes "head"
            current.next = head;
            //head then becomes the value current was declared as
            head = current;
            /*as a result, the value inserted becomes the new head, with the rest
             *of the list following after*/
            //current is now the value of head
        }

        //the list is empty
        else
            head = current = new IntListElement(value);
    }

    int next() {
        previous = current;
        //if current hasn't been declared, current equals the beginning of the list
        if (current == null)
            current = head;
        //else the current value becomes the next element in the list
        else
            current = current.next;
        return current.data;
    }

    //tells what the current element which the user is on
    int current() {
        return current.data;
    }

    void remove() {
        //doesn't do anything if there is no head or no current
        if (head == null) return;
        if (current == null) return;
        //if on the first element, moves the first element forward by one
        if (current == head)
            head = current = current.next;
        /*else uses previous to link the element prior to the removed element
        *"current" to the element that followed the removed element "current"*/
        else
            current = previous.next = current.next;        
    }

    void moveToHead() {
        //
        previous = current = null;
    }

    boolean hasNext() {
        //test whether list is empty
        if (current != null)
            return current.next != null;
        //test whether the next field of current isn't null (would occur at end of list)
        else
            return head != null;
    }

    public String toString() {
        IntListElement cursor = head;
        StringBuffer result = new StringBuffer();

        while (cursor != null) {
            result.append(cursor.data + "\n");
            cursor = cursor.next;
        }

        return result.toString();
    }
}