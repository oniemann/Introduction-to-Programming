class NumberList {
    public static void main(String[] args) {
        List list = new List();

        for (int i = 1; i <= 10; i++) {
            list.insert(i);
        }

        System.out.println(list);

    }
}