class CounterTest {
    public static  void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.click();
        c2.click();
        c2.click();
        System.out.println("Counter1 value is: " + c1.get());
        System.out.println("Counter2 value is: " + c2.get());
        c1.reset();
        System.out.println("Counter1 value is " + c1.get());
    }
}

class Counter {
    int value;

    void reset() {
        value = 0;
    }

    int get() {
        return value;
    }

    void click() {
        value = (value + 1) % 100;
    }
}