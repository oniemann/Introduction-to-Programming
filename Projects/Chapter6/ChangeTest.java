import java.util.*;
import java.io.*;

public class ChangeTest {
    public static void main(String[] args) {
        Change c1 = new Change(10, 3, 4, 3);
        Change c2 = new Change(7, 2, 2, 1);
        Change sum = c1.add(c2);
        Change difference = Change.subtract(c1, c2);
        System.out.println("sum: " + sum);
        System.out.println("difference: " + difference);
    }


}