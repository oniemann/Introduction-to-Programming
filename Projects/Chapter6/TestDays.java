import java.util.*;
import java.io.*;

class TestDays {
    public static void main(String[] args) {
        Days today = Days.friday;

        System.out.println("Today is: " + today);
        //next two lines refer to instance methods located in enum "Days"
        System.out.println("Tomorrow is: " + today.nextDay());
        System.out.println("Yesterday was: " + today.priorDay());
        System.out.println("");
        //Days.values() iterates over enum "days"
        for(Days d: Days.values())
            //d.name() converts number to name in enum based on name's ordinal #
            System.out.println(d.name() + " is on the weekend is " + d.isWeekend());
    }

}

enum Days {
    sunday, monday, tuesday, wednesday, thursday, friday, saturday;
    public Days nextDay() {
        /*below  switches shorthand for "this.ordinal()", which converts the
       value of type "day" into an integer.*/
        switch(this){
            case sunday:    return(Days.monday);
            case monday:    return(Days.tuesday);
            case tuesday:   return(Days.wednesday);
            case wednesday: return(Days.thursday);
            case thursday:  return(Days.friday);
            case friday:    return(Days.saturday);
            default:        return(Days.sunday);
        }
    }

    public Days priorDay() {
        switch(this){
            case sunday:    return(Days.saturday);
            case monday:    return(Days.sunday);
            case tuesday:   return(Days.monday);
            case wednesday: return(Days.tuesday);
            case thursday:  return(Days.wednesday);
            case friday:    return(Days.thursday);
            default:        return(Days.friday);
        }
    }

    //checks if a given day is on the weekend ---> returns "true" or "false"
    public boolean isWeekend() {
        return (this.equals(sunday) || this.equals(saturday));
    }
}