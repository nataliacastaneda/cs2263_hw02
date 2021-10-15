package edu.isu.cs2263.hw02;
//This class creates course objects.
public class Course {
    //attributes
    private int number;
    private String subject;
    private String title;

    //constructor
    public Course (int num, String sub, String theTitle){
        number = num;
        subject = sub;
        title = theTitle;
    }

    //methods
    public String toString(){
        return number + " " + subject + " " + title;}

    //setter methods
    public void setNumber(int num){number = num;}
    public void setSubject(String sub){subject = sub;}
    public void setTitle(String theTitle){title = theTitle;}

    //getter methods
    public int getNumber(){return number;}
    public String getSubject(){return subject;}
    public String getTitle(){return title;}

}
