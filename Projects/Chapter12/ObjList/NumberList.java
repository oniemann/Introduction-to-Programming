class NumberList {
    public static void main(String[] args) {
        List list = new List();

        for (int i = 1; i <= 10; i++) {
            list.insert(i);
        }

        list.movetohead();

        for (int i = 1; i <= 5; i++) 
            list.next();

        list.insert("Oh Hey!!");

        list.movetohead();

        for (int i = 1; i <= 10; i++)
           System.out.println(list.next());
    }
}