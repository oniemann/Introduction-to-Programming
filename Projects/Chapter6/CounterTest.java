class CounterTest {
    public static  void main(String[] args) {
        Counter c1 = new Counter(5);
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        c1.click();
        c3.click();
        
        int i = 0;

        while(i < 155){
            c2.click();
            ++i;
        }

        System.out.println("Counter1 value is: " + c1.get());
        System.out.println("Counter2 value is: " + c2.get());
        System.out.println("Counter3 value is: " + c3.get());
        c1.reset();
        System.out.println("After resetting, Counter1 value is: " + c1.get());
        System.out.println("The number of counters declared is: " + c1.howMany());
    }
}

class Counter {
    //instance variable, visible to all methods in this class
    private int value;

    //universal to class, i.e. holds the same value in objects c1, c2, c3
    private static int howMany = 0;

    /*constructors, takes into account conditions where there is/isn't an
    argument passed into "new Counter()".*/
    public Counter() {
        howMany++; 
    }
  
    public Counter(int v) {
        value = v % MODULUS;
        howMany++;
    }

    //instance method, doesn't do anything but declare intitial value for 
    //instance variable "value"
    public void reset() {
        value = 0;
    }

    //accessor method, returns integer "value"
    public int get() {
        return value;
    }

    //mutator method, manipulates instance variable "value"
    public void click() {
        value = (value + 1) % MODULUS;
    }

    public static int howMany() {
        return howMany;
    }

    private static final int MODULUS = 100;
}