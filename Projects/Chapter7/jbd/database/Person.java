package jbd.database;

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
