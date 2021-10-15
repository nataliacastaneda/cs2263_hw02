package edu.isu.cs2263.hw02;

import java.util.List;
//This class creates student objects. Ideally, students would be able to have more
//than one class, but this program only allows them one.
public class Student{
    //attributes
    private String firstName;
    private String lastName;
    private Course studentCourse;

    //constructor
    public Student (String fName, String lName, Course sCourse){
        firstName = fName;
        lastName = lName;
        studentCourse = sCourse;
    }
    //methods
    public String toString(){
        return firstName + " " + lastName;}

    //setter methods
    public void setFirstName(String fName){firstName = fName;}
    public void setLastName(String lName){lastName = lName;}

    //getter methods
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public Course getStudentCourse(){return studentCourse;}



}
