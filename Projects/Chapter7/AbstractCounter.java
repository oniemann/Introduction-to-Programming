void sampleMethod(AbstractCounter counter) {
    //...
    counter.click();
    //...
}



//the following class will be the "superclass"
abstract public class AbstractCounter {
    abstract public void click();
    public int get() {return value;}
    public void set(int x) {value = x;}
    public String toString() {return String.valueOf(value);}
    protected int value;
}

//below two add the minimum amount of implementation possible
//counts by one
public class Counter extends AbstractCounter {
    public void click() {value = (value + 1) % 100;}
}

//counts by two
public class CountByTwo extends AbstractCounter {
    public void click() {value = (value + 2) % 100;}
}

/*this subclass overrides the method set() in addition to providing implementation
for click()*/
//treats each click as a second of time

class Timer extends AbstractCounter {
    public Timer(int v) {set(v);}
    
    public void click() {
        value++;
        seconds = value % 60;
        minutes = value / 60;
    }

    public String toString() {
        return minutes + "minutes, " + seconds + " seconds";
    }

    private int seconds, minutes;
}

//could also implement timer as:

class Timer extends AbstractCounter {
    public Timer(int v) {set(v);}
    public void click() {value++;}
    public String toString() {
        return (value / 60) + "minutes, " + (value % 60) + " seconds";
    }
}

//if wanted to click timer more frequently than it is displayed