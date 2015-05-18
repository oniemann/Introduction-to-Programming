package jbd.database;

//below is a subclass extending from the above "superclass"
class Student extends Person {
    Student(String name) {super(name);}  //gives the subclass the constructor of the superclass
    
    void setCollege(String college) {this.college = college;}
    void setGPA(double gpa) {this.gpa = gpa;}
    void setYear(YearinSchool year) {this.year = year;}

    String getCollege() {return college;}
    double getGPA() {return gpa;}
    YearinSchool getYear() {return year;}

    /*below overrides the same method in the superclass, but can access the return method
    from the superclass by syntax  "super.toString"*/
    public String toString() {
        return(super.toString() + "\n  " + "College: " + college + ", GPA: " + gpa + ", Year: " + year);
    }

    static enum YearinSchool {freshman, sophomore, junior, senior}

    private String college = "Unknown";
    private double gpa;
    private YearinSchool year;
}