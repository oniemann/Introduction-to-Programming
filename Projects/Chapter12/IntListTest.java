class IntListTest {
    public static void main(String[] args) {
        IntList list = new IntList();
        //insert integers 1-10 in the list
        for (int i = 1; i <= 10; i++)
            list.insert(i);
        //print the list
        list.moveToHead();

        while (list.hasNext())
            System.out.println(list.next());

        list.moveToHead();
        list.next();
        list.next();
        list.insert(25);
        list.next();
        list.remove();
        //print the list again
        list.moveToHead();
        while (list.hasNext())
            System.out.println(list.next());
    }
}