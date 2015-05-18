class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("Okeefe Niemann");
        student.setAge(22);
        student.setGender(Person.Gender.M);
        student.setCollege("UCSC");
        student.setYear(Student.YearinSchool.senior);
        student.setGPA(3.7);
        System.out.println(student.toString());

        Person anyPerson = student;
        System.out.println(anyPerson.toString());
    }
}

//class describes a person by name, age, and gender
class Person{
    Person(String name) {this.name = name;}

    void setAge(int age) {this.age = age;}
    void setGender(Gender gender) {this.gender = gender;}
    void setName(String name) {this.name = name;}

    int getAge() {return age;}
    Gender getGender() {return gender;}
    String getName() {return name;}

    public String toString() {
        return("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }

    static enum Gender{ M, F }

    private String name;
    private int age;
    private Gender gender;
}

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