/*
when executed, returns "2, 1"
2 is printed because two indices are of the same object counter "counterArray"
1 is printed because in String class, just looks to see if the array contains a 
    String equal to "String 1", for which there is only 1   
*/

public class EqualsTest{
    public static void main(String[] args) {
        //create & fill array of strings
        String[] stringArray = new String[10];

        for(int i = 0; i < stringArray.length; i++)
            stringArray[i] = "String " + i;

        //create and fill an array of counters
        Counter[] counterArray = new Counter[5];

        for (int i = 0; i < counterArray.length; i++)
            counterArray[i] = new Counter();

        //make two entries which refer to the same counter
        counterArray[2] = counterArray[0];

        System.out.println(howManyCopiesOf(counterArray[0], counterArray));
        System.out.println(howManyCopiesOf("String 1", stringArray));
    }

    //counts number of times obj is found in array
    static int howManyCopiesOf(Object obj, Object[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (obj.equals(array[i]))
                count++;
        }

        return count;
    }
}