import java.util.*;
import java.io.*;

class SameName {
    public static void main(String[] args) {
        //declares and constructs a person
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "Okeefe Niemann";
        p2.name = "Okeefe Niemann";
        p1.phoneNumber = "(904) 347-3589";
        p2.phoneNumber = "(904) 347-4767";
        
        print(p1);
        print(p2);

        if(sameNumber(p1, p2))
            System.out.println("These guys have the same number, so they're the same person..");
        else
            System.out.println("These guys have different numbers, so they're different people..");
    }

    static void print(Person p) {
        System.out.println(p.name + "'s phone number is: " + p.phoneNumber);
    }
    static boolean sameNumber(Person p, Person q) {
        return p.phoneNumber.equals(q.name);
    }
}

class Person {
    //below two variables referred to as "data member" or "field"
    String name;
    String phoneNumber;
}