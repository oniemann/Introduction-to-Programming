//Person.java
interface Person {
    void setAge(int age);
    void setGender(char gender);
    void setName(String name);
    int getAge();
    char getGender();
    String getName();
}

//Student.java
interface Student extends Person {
    void setCollege(String college);
    void setGpa(double gpa);
    void setYear(byte year);
    String getCollege();
    double getGpa();
    byte getYear();
    static enum YearInSchool {frosh, sophomore, junior, senior}
}

//Staff.java
import java.util.Date;

interface Staff extends Person {
    void setSalary(double salary);
    void setStartDate(Date start);
    void setEndDate(Date end);
    void setSSN(String ssn);
    double getSalary();
    Date getStartDate();
    Date getEndDate();
    String getSSN();
}

//now, let's create a student employee class

class StudentEmployee implements Student, Staff {
    //methods required by person
    public void setAge(int age) {}
    //setGender
    //setName
    //getAge
    //getGender
    //getName

    //methods required by student
    public void setCollege(String college) {}
    //setGpa
    //setYear
    //getCollege
    //getGpa
    //getYear

    //methods required by staff
    public void setSalary(double salary) {}
    //setStartDate
    //setEndDate
    //setSSN
    //getSalary
    //getStartDate
    //getEndDate
    //getSSN
}

/*
-instances of the above class can be passed to methods that expect as parameters
any of StudentEmployee, Student, Staff, or Person
-given up some degree of code use in doing multiple inheritance
    i.e. setAge() implementation has to occur in every class that implements the
    interface "Person," directly or indirectly.
*/