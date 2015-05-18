import java.util.*;

public class MakingChange {
    public static void main(String[] args) {
        System.out.println("How much money owed?");
        Scanner scan = new Scanner(System.in);
        double owed = scan.nextDouble();
        System.out.println("How much money paid?");
        double paid = scan.nextDouble();
        System.out.printf("%nYou owed $%.2f%n", owed);
        System.out.printf("You gave me $%.2f%n", paid);
        System.out.println("Your change is " + Change.makeChange(paid, owed));

    }
}

class Change {
    private int dollars, quarters, dimes, pennies;
    private double total;

    /*was only using abbreviations (dlr,qrtr,dm,pen) for the formal parameters
    to avoid them having conflict with the names of instance variables
    ---> using "this" eliminates the need for alternative names while still
    having the ability to access the instance variables
    ---> useful for when you need to pass a reference to "this" object to some
    other method. Without the "this" reference, couldn't pass the current object
    to another method*/
    Change(int dollars, int quarters, int dimes, int pennies) {
        this.dollars = dollars;
        this.quarters = quarters;
        this.dimes = dimes;
        this.pennies = pennies;
        total = dollars + .25 * quarters + .1 * dimes + .01 * pennies;
    }

    static Change makeChange(double paid, double owed) {
        double diff = owed - paid;
        int dollars, quarters, dimes, pennies;
        dollars = (int)diff;
        pennies = (int)Math.round((diff-dollars) * 100);
        quarters = pennies / 25;
        pennies -= 25 * quarters;
        dimes = pennies / 10;
        pennies  -= 10 * dimes;
        return new Change(dollars, quarters, dimes, pennies);
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        Formatter out = new Formatter(result);
        out.format("$%.2f%n%d dollars%n%d quarters%n" + "%d dimes%n%d pennies%n",
            total, dollars, quarters, dimes, pennies);
        return result.toString();
    }

    public Change add(Change addend) {
        Change result = new Change(dollars + addend.dollars, quarters + addend.quarters,
            dimes + addend.dimes, pennies + addend.pennies);
        return result;
    }

    public static Change subtract(Change augend, Change addend) {
        Change result = new Change(augend.dollars - addend.dollars,
            augend.quarters - addend.quarters, augend.dimes - addend.dimes,
            augend.pennies - addend.pennies);
        return result;
    }
}